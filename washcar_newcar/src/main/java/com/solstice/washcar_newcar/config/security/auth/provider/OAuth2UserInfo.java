package com.solstice.washcar_newcar.config.security.auth.provider;

public interface OAuth2UserInfo {
  String getProviderId();

  Provider getProvider();

  String getEmail();

  String getName();
}
