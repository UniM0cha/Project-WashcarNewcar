package com.solstice.washcar_newcar.data.dto.requestToWhattime;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WhattimeRequestStore {
  private String name;
  private String profileImage;
  private String info;
  private List<WhattimeRequestStoreImage> storeImages;
  private List<WhattimeRequestMenu> menus;
  // private WhattimeLocationDto location;

  public Store whattimeRegister(User user, String whattimeuserCode) {
    return Store.builder()
        .user(user)
        .name(this.name)
        .profileImage(this.profileImage)
        .info(this.info)
        .whattimeUserCode(whattimeuserCode)
        .build();
  }
}