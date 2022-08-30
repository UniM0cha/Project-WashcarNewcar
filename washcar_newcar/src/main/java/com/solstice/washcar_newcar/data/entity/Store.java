package com.solstice.washcar_newcar.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Store {

  @Id
  @GeneratedValue
  private Long storeNumber;

  private String name;
  private String profileImage;
  private String info;
  private String whattimeUserCode;

  // 연관관계의 주인은 외래키가 있는 곳
  @Builder.Default
  @OneToMany(mappedBy = "store")
  private List<StoreImage> storeImages = new ArrayList<>();

  @Builder.Default
  @OneToMany(mappedBy = "store")
  private List<Menu> menus = new ArrayList<>();

  @OneToOne(mappedBy = "store", fetch = FetchType.LAZY)
  private Location location;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(unique = true)
  private User user;
}
