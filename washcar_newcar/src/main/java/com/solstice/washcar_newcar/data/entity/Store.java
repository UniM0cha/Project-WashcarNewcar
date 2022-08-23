package com.solstice.washcar_newcar.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.solstice.washcar_newcar.data.dto.Location;

@Entity
public class Store {

  @Id
  @GeneratedValue
  private Long storeNumber;
  private String location;
  private String name;
  private String profileImage;
  private String storeImage;
  private String info;
  private String whattimeId;

  @OneToOne
  private User user;
}
