package com.solstice.washcar_newcar.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;

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
  private String organizationId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role = Role.ROLE_CLIENT; // ROLE_USER, ROLE_

  @Enumerated(EnumType.STRING)
  private Provider provider;
  private String providerId;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date createDate;

  private Date loginedDate;

  @Builder
  public User(Long userNumber, String userId, @Email String email, String password, String nickname,
      String organizationId, Role role, Provider provider, String providerId, Date createDate, Date loginedDate) {
    this.userNumber = userNumber;
    this.userId = userId;
    this.email = email;
    this.password = password;
    this.nickname = nickname;
    this.organizationId = organizationId;
    this.role = role;
    this.provider = provider;
    this.providerId = providerId;
    this.createDate = createDate;
    this.loginedDate = loginedDate;
  }

}
