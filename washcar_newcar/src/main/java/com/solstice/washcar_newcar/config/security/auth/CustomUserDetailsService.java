package com.solstice.washcar_newcar.config.security.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    log.info("loadUserByUsername 호출");

    User foundUser = userRepository.findByUserId(userId);
    if (foundUser == null) {
      throw new UsernameNotFoundException("해당 유저ID를 찾을 수 없습니다.");
    }
    return new OAuth2UserDetails(foundUser);
  }

}
