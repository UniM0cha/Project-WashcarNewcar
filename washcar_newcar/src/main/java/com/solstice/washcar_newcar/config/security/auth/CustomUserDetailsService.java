package com.solstice.washcar_newcar.config.security.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info(username);
    return null;
  }

}
