package com.solstice.washcar_newcar.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreImage {
  @Id
  @GeneratedValue
  private Long storeImageNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  private Store store;

  private String url;

  public StoreImage setStore(Store store) {
    return StoreImage.builder()
        .store(store)
        .url(this.url)
        .build();
  }
}
