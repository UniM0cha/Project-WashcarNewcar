package com.solstice.washcar_newcar.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;

import com.solstice.washcar_newcar.config.security.auth.Role;
import com.solstice.washcar_newcar.config.security.auth.provider.Provider;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @Enumerated(EnumType.STRING)
  private Provider provider;

  private String providerId;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  @Column(nullable = false)
  private Date createDate;

  @Temporal(TemporalType.TIMESTAMP)
  private Date loginedDate;

  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
  private Store store;
}

/**
 * @ManyToOne, @OneToOne : 즉시로딩
 * @OneToMany, @ManyToMany : 지연로딩
 */