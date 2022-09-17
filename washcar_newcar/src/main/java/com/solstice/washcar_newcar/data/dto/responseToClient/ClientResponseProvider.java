package com.solstice.washcar_newcar.data.dto.responseToClient;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
public class ClientResponseProvider {
  private boolean isFirst;
  private List<ClientResponseCalendar> menus;
}
