package com.solstice.washcar_newcar.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;

import com.solstice.washcar_newcar.config.security.auth.OAuth2UserDetails;
import com.solstice.washcar_newcar.config.security.auth.Role;
import com.solstice.washcar_newcar.config.security.auth.provider.Provider;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private Long userNumber;

  @Column(nullable = false, unique = true)
  private String userId;

  @Email
  @Column(nullable = false, unique = true)
  private String email;

  private String password;
  private String nickname;
  // whattime user code
  private String userCode;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role = Role.ROLE_CLIENT;

  @Enumerated(EnumType.STRING)
  private Provider provider;
  private String providerId;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date createDate;

  private Date loginedDate;

  @OneToOne
  private Store store;

  @Builder
  public User(Long userNumber, String userId, @Email String email, String password, String nickname,
      String userCode, Role role, Provider provider, String providerId, Date createDate, Date loginedDate,
      Store store) {
    this.userNumber = userNumber;
    this.userId = userId;
    this.email = email;
    this.password = password;
    this.nickname = nickname;
    this.userCode = userCode;
    this.role = role;
    this.provider = provider;
    this.providerId = providerId;
    this.createDate = createDate;
    this.loginedDate = loginedDate;
    this.store = store;
  }

  public User(User user, String userCode) {
    this.userNumber = user.userNumber;
    this.userId = user.userId;
    this.email = user.email;
    this.password = user.password;
    this.nickname = user.nickname;
    this.userCode = userCode;
    this.role = user.role;
    this.provider = user.provider;
    this.providerId = user.providerId;
    this.createDate = user.createDate;
    this.loginedDate = user.loginedDate;
    this.store = user.store;
  }

}
