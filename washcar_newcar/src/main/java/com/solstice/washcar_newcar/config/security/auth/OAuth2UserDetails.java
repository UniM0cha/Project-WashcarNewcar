package com.solstice.washcar_newcar.config.security.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.solstice.washcar_newcar.data.entity.User;

public class OAuth2UserDetails implements UserDetails, OAuth2User {

  private User user;
  private Map<String, Object> attributes;

  // 일반 로그인에 쓰이는 생성자
  public OAuth2UserDetails(User user) {
    this.user = user;
  }

  // OAuth 로그인에 쓰이는 생성자
  public OAuth2UserDetails(User user, Map<String, Object> attributes) {
    this.user = user;
    this.attributes = attributes;
  }

  /////////////////// OAuth2User 구현 /////////////////

  @Override
  public Map<String, Object> getAttributes() {
    return attributes;
  }

  // 원래 쓰이는거긴 한데 지금은 클래스를 따로 정의해놨으니 필요 없음
  @Override
  public String getName() {
    return null;
  }

  ////////////////// UserDetails 구현 //////////////////
  /**
   * 해당 유저의 권한 목록 리턴
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collection = new ArrayList<>();
    collection.add(new GrantedAuthority() {
      @Override
      public String getAuthority() {
        return user.getRole().name();
      }
    });
    return collection;
  }

  /**
   * 비밀번호를 리턴
   */
  @Override
  public String getPassword() {
    return user.getPassword();
  }

  /**
   * PK값을 리턴
   */
  @Override
  public String getUsername() {
    return user.getUserId();
  }

  /**
   * 계정 만료 여부
   * true : 만료 안됨
   * false : 만료됨
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * 계정 잠김 여부
   * true : 잠기지 않음
   * false : 잠김
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * 계정 비밀번호 만료 여부
   * true : 만료 안됨
   * false : 만료됨
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * 계정 활성화 여부
   * true : 활성화됨
   * false : 비활성화됨
   */
  @Override
  public boolean isEnabled() {
    return true;
  }

}
