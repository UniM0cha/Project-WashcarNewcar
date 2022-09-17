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
public class Menu {
  @Id
  @GeneratedValue
  private Long menuNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  private Store store;

  private String whattimeCalendarCode;

  public Menu setStore(Store store) {
    return Menu.builder()
        .whattimeCalendarCode(this.whattimeCalendarCode)
        .store(store)
        .build();
  }
}
