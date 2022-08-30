package com.solstice.washcar_newcar.data.dto.requestFromClient;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.StoreImage;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientStoreImageDto {
  private String url;

  public StoreImage toEntity() {
    return StoreImage.builder()
        .url(this.url)
        .build();
  }

  public StoreImage toEntity(Store store) {
    return StoreImage.builder()
        .store(store)
        .url(this.url)
        .build();
  }
}
