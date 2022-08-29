package com.solstice.washcar_newcar.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Store {

  @Id
  @GeneratedValue
  private Long storeNumber;

  private String name;
  private String profileImage;
  private String info;
  private String whattimeUserCode;

  // 연관관계의 주인은 외래키가 있는 곳
  @OneToMany(mappedBy = "store", cascade = CascadeType.PERSIST)
  private List<StoreImage> storeImages = new ArrayList<>();

  @OneToMany(mappedBy = "store", cascade = CascadeType.PERSIST)
  private List<Menu> menus = new ArrayList<>();

  @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  private Location location;

  @OneToOne(fetch = FetchType.LAZY)
  private User user;

  @Builder
  public Store(Long storeNumber, String name, String profileImage, String info, String whattimeUserCode,
      List<StoreImage> storeImages, List<Menu> menus, Location location, User user) {
    this.storeNumber = storeNumber;
    this.name = name;
    this.profileImage = profileImage;
    this.info = info;
    this.whattimeUserCode = whattimeUserCode;
    this.menus = menus;
    this.storeImages = storeImages;
    this.location = location;
    this.user = user;
  }

}
