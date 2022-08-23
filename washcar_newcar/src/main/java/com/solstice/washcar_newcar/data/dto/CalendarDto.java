package com.solstice.washcar_newcar.data.dto;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class CalendarDto {
  private String code;
  private String url;
  private String name;
  private String slug;
  private String color;
  private String description;
  private int max_invitee;
  private boolean show_remain;
  private int order;
  private boolean secret;
  private boolean active;
}
