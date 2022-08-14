package com.solstice.washcar_newcar.config.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    // 로그인 성공한 사용자 정보
    // OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

    // @SuppressWarnings("unchecked")
    // Map<String, Object> kakaoAccount = (Map<String, Object>)
    // oAuth2User.getAttributes().get("kakao_account");
    // String email = (String) kakaoAccount.get("email");

    // // String jwt = jwtTokenUtil.generateTokenForOAuth("kakao", email);
    // // String url = makeRedirectUrl(jwt);
    // // System.out.println("url: " + url);

    // String token = "dfsdsfsdf";

    response.sendRedirect("http://localhost:3000/");
  }
}
