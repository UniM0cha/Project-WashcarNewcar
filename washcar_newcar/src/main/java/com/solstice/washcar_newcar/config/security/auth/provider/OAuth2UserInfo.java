package com.solstice.washcar_newcar.config.security.auth.provider;

import com.solstice.washcar_newcar.data.entity.Provider;

public interface OAuth2UserInfo {
  String getProviderId();

  Provider getProvider();

  String getEmail();

  String getName();
}
