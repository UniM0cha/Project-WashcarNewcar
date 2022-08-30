package com.solstice.washcar_newcar.data.dto.requestFromClient;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.entity.Menu;
import com.solstice.washcar_newcar.data.entity.Store;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientMenuDto {
  private String whattimeCalendarCode;

  public Menu toEntity(Store store) {
    return Menu.builder()
        .whattimeCalendarCode(this.whattimeCalendarCode)
        .store(store)
        .build();
  }
}
