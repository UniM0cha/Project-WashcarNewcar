package com.solstice.washcar_newcar.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
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
