package com.solstice.washcar_newcar.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;

@Entity
@Getter
public class Location {

  @Id
  @GeneratedValue
  private Long locationId;
  // 위도
  private Double latitude;
  // 경도
  private Double longitude;

  @OneToOne
  private Store store;
}
