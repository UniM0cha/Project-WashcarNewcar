package com.solstice.washcar_newcar.config.security.jwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.solstice.washcar_newcar.config.security.auth.CustomUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

  private final CustomUserDetailsService customUserDetailsService;

  @Value("${jwt.secret}")
  private String secretKey = "secretKey";
  private static Key JWT_SECRET;

  private static final int JWT_EXPIRATION_MS = 1000 * 60 * 60 * 24; // 24시간

  @PostConstruct
  protected void init() {
    JWT_SECRET = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
  }

  // OAuth2AuthenticationSuccessHandler에서 받아온 Authentication 객체에서
  // 사용자 정보를 뽑아내 JWT 토큰 생성
  public String generateToken(Authentication authentication) {
    Date now = new Date();
    Date expireDate = new Date(now.getTime() + JWT_EXPIRATION_MS);

    return Jwts.builder()
        .setSubject(authentication.getName())
        .setIssuedAt(now)
        .setExpiration(expireDate)
        .signWith(JWT_SECRET, SignatureAlgorithm.HS512)
        .compact();
  }

  // JWT 토큰에서 아이디 추출
  public String getUsernameFromJwt(String token) {
    Claims claims = (Claims) Jwts.parserBuilder()
        .setSigningKey(JWT_SECRET)
        .build()
        .parse(token)
        .getBody();

    return claims.getSubject();
  }

  // jwt 토큰의 유효성 검사
  public boolean validateToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(JWT_SECRET).build().parseClaimsJws(token);
      return true;
    } catch (MalformedJwtException ex) {
      log.info("유효하지 않은 JWT");
    } catch (ExpiredJwtException ex) {
      log.info("만료된 JWT");
    } catch (UnsupportedJwtException ex) {
      log.info("지원되지 않는 JWT");
    } catch (IllegalArgumentException ex) {
      log.info("JWT의 Claims가 비어있음");
    } catch (SignatureException ex) {
      log.info("JWT 시그니쳐 일치하지 않음");
    }
    return false;
  }

  public Authentication getAuthenticationFromToken(String token) {
    UserDetails userDetails = customUserDetailsService.loadUserByUsername(getUsernameFromJwt(token));
    return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
  }

}
