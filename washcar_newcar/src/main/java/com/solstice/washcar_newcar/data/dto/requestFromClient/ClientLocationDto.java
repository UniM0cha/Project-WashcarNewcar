package com.solstice.washcar_newcar.data.dto.requestFromClient;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.entity.Location;
import com.solstice.washcar_newcar.data.entity.Store;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientLocationDto {
  private Double latitude;
  private Double longitude;

  public Location toEntity(Store store) {
    return Location.builder()
        .latitude(this.latitude)
        .longitude(this.longitude)
        .store(store)
        .build();
  }
}