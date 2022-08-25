package com.solstice.washcar_newcar.config.security.auth;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.solstice.washcar_newcar.config.security.auth.provider.OAuth2UserInfo;
import com.solstice.washcar_newcar.config.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private final JwtTokenProvider jwtTokenProvider;

  @Value("${front_server}")
  private String frontServer;

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    // 로그인 성공한 사용자 정보를 토대로 jwt 생성
    String jwt = jwtTokenProvider.generateToken(authentication);
    response.sendRedirect(frontServer + "/oauth2/redirect/" + jwt);
  }
}
