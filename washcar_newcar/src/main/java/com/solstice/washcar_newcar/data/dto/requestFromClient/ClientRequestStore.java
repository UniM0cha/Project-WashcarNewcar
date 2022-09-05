package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientRequestStore {
  private String name;
  private String slug;
  private String address;
  private String addressDetail;
  private String route;
  private String info;
  private String profileImage;
  private List<ClientRequestStoreImage> storeImages;
  // private List<ClientRequestMenu> menus;
  // private ClientRequestLocation location;

  public Store toEntity(User user, String whattimeUserCode) {
    return new Store(null, name, profileImage, info, whattimeUserCode,
        null, null, address, addressDetail, user);
  }
}