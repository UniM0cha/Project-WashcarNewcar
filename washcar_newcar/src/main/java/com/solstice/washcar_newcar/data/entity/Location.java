package com.solstice.washcar_newcar.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

  @Id
  @GeneratedValue
  private Long locationId;
  // 위도
  private Double latitude;
  // 경도
  private Double longitude;

  @OneToOne(fetch = FetchType.LAZY)
  private Store store;

  public Location setStore(Store store) {
    return Location.builder()
        .latitude(this.latitude)
        .longitude(this.longitude)
        .store(store).build();
  }
}
