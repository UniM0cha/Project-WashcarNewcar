package com.solstice.washcar_newcar.config.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtTokenProvider jwtTokenProvider;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      String jwt = getJwtFromRequest(request); // request에서 jwt 토큰을 꺼낸다.
      if (jwt != null && jwtTokenProvider.validateToken(jwt)) {

        // jwt로부터 Authentication 객체를 만들어서 받아온다.
        Authentication authentication = jwtTokenProvider.getAuthenticationFromToken(jwt);
        SecurityContextHolder.getContext().setAuthentication(authentication); // securityContext에 Authentication 등록
      }
    } catch (Exception ex) {
      logger.error("SecurityContext에 Authentication을 등록할 수 없습니다.", ex);
    }

    filterChain.doFilter(request, response);
  }

  private String getJwtFromRequest(HttpServletRequest request) {
    // Authorization 헤더에서 bearer 토큰을 받아옴
    String bearerToken = request.getHeader("Authorization");

    // 토큰이 있는지, Bearer로 시작하는지 확인
    if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
      // 그 후 토큰값만 잘라서 리턴
      return bearerToken.substring("Bearer ".length());
    }
    return null;
  }
}
