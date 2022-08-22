package com.solstice.washcar_newcar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solstice.washcar_newcar.config.security.auth.provider.Provider;
import com.solstice.washcar_newcar.data.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
  public User findByProviderAndProviderId(Provider provider, String providerId);

  public User findByUserId(String userId);
}
