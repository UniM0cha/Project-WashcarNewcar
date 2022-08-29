package com.solstice.washcar_newcar.data.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class StoreRegisterDto {
  private String name;
  private String profileImage;
  private String info;
  private List<StoreImageDto> storeImages;
  private List<MenuDto> menus;
  private LocationDto location;
}