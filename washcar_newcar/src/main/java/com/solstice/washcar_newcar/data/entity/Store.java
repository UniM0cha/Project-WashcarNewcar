package com.solstice.washcar_newcar.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;

@Entity
@Getter
public class Store {

  @Id
  @GeneratedValue
  private Long storeNumber;

  private String name;
  private String profileImage;
  private String storeImage;
  private String info;
  private String whattimeId;

  @OneToOne
  private Location location;

  @OneToOne
  private User user;
}
