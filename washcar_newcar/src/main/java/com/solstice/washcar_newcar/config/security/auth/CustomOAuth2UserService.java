package com.solstice.washcar_newcar.config.security.auth;

import java.util.Map;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.solstice.washcar_newcar.config.security.auth.provider.KakaoUserInfo;
import com.solstice.washcar_newcar.config.security.auth.provider.OAuth2UserInfo;
import com.solstice.washcar_newcar.config.security.auth.provider.Provider;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.repository.UserRepository;
import com.solstice.washcar_newcar.service.WhattimeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

  private final UserRepository userRepository;
  private final WhattimeService whattimeService;

  /**
   * loadUser 메서드는 사용자 정보를 요청할 수 있는 access token을 얻고 나서 실행된다.
   */

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    // DefaultOAuth2UserService의 loadUser 메서드를 사용하면 User정보를 받아온다.
    OAuth2User oAuth2User = super.loadUser(userRequest);

    Map<String, Object> attributes = oAuth2User.getAttributes();

    OAuth2UserInfo oAuth2UserInfo = null;
    switch (userRequest.getClientRegistration().getRegistrationId()) {
      case "kakao":
        log.info("카카오 로그인 요청 : " + oAuth2User.toString());
        oAuth2UserInfo = new KakaoUserInfo(attributes);
        break;
      default:
        log.error("다른 플랫폼의 로그인 요청");
        break;
    }

    Provider provider = oAuth2UserInfo.getProvider();
    String providerId = oAuth2UserInfo.getProviderId();
    String userId = provider.toString() + "_" + providerId;
    String email = oAuth2UserInfo.getEmail();
    Role role = Role.ROLE_PROVIDER;

    User foundUser = userRepository.findByProviderAndProviderId(provider, providerId);

    // 회원가입
    OAuth2UserDetails oAuth2UserDetails = null;
    if (foundUser == null) {
      log.info("회원가입을 진행합니다.");

      User newUser = User.builder()
          .userId(userId)
          .provider(provider)
          .providerId(providerId)
          .email(email)
          .role(role)
          .build();

      // 되는시간 회원가입
      User whattimeRegisteredUser = whattimeService.register(newUser);

      userRepository.save(whattimeRegisteredUser);
      oAuth2UserDetails = new OAuth2UserDetails(whattimeRegisteredUser, attributes);
    } else {
      oAuth2UserDetails = new OAuth2UserDetails(foundUser, attributes);
    }

    // 여기서 리턴한 객체가 시큐리티 세션의 Authentication 객체에 저장된다.
    return oAuth2UserDetails;
  }

}
