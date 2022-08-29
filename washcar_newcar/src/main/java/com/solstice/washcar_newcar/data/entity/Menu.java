package com.solstice.washcar_newcar.data.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class Menu {
  @Id
  @GeneratedValue
  private Long menuNumber;

  @ManyToOne(fetch = FetchType.LAZY)
  private Store store;

  private String whattimeCalendarCode;
}
