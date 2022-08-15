package com.solstice.washcar_newcar.data.entity;

import java.util.Date;
import java.util.UUID;

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

  @Column(nullable = false)
  private String userId;

  @Email
  @Column(nullable = false)
  private String email;

  private String password;
  private String nickname;

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
  public User(Long userNumber, String userId, String password, @Email String email, Role role, Provider provider,
      String providerId,
      Date createDate, Date loginedDate) {
    this.userNumber = userNumber;
    this.userId = userId;
    this.password = password;
    this.email = email;
    this.role = role;
    this.provider = provider;
    this.providerId = providerId;
    this.createDate = createDate;
    this.loginedDate = loginedDate;
  }

}
