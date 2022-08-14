package com.solstice.washcar_newcar.config.security;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

  /**
   * loadUser 메서드는 사용자 정보를 요청할 수 있는 access token을 얻고 나서 실행된다.
   */

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    // DefaultOAuth2UserService의 loadUser 메서드를 사용하면 User정보를 받아온다.
    OAuth2User oAuth2User = super.loadUser(userRequest);

    Map<String, Object> attributes = oAuth2User.getAttributes();

    @SuppressWarnings("unchecked")
    Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");

    String email = (String) kakaoAccount.get("email");

    /**
     * TODO: 회원가입 로직
     */

    // DefaultOAuth2User의 생성자를 통해 ROLE_MEMBER를 가지고 있는 새로운 OAuth2User 객체를 만든다.
    OAuth2User newUser = new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority("ROLE_MEMBER")),
        attributes, "id");
    log.info("UserPrincipal : " + newUser.toString());

    // 여기서 리턴한 객체가 시큐리티 세션의 UserPrincipal에 저장된다.
    return newUser;
  }

}
