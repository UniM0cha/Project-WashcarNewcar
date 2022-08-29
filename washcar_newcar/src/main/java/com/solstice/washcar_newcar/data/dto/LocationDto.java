package com.solstice.washcar_newcar.data.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.entity.Location;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LocationDto {
  private Double latitude;
  private Double longitude;

  public Location toEntity() {
    return Location.builder()
        .latitude(this.latitude)
        .longitude(this.longitude)
        .build();
  }
}