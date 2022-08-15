package com.solstice.washcar_newcar.config.security.auth.provider;

import java.util.Map;

import com.solstice.washcar_newcar.data.entity.Provider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KakaoUserInfo implements OAuth2UserInfo {

  private Map<String, Object> attributes;

  public KakaoUserInfo(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String getProviderId() {
    Long id = (Long) attributes.get("id");
    return id.toString();
  }

  @Override
  public Provider getProvider() {
    return Provider.Kakao;
  }

  @Override
  public String getEmail() {
    @SuppressWarnings("unchecked")
    Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
    return (String) kakaoAccount.get("email");
  }

  @Override
  public String getName() {
    return (String) attributes.get("id");
  }

}
