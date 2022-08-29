package com.solstice.washcar_newcar.data.whattime;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Calendar {
  private String uri;
  private String url;
  private String code;
  private String kind;
  private String name;
  private String reservationUrl;
  private String slug;
  private String color;
  private String description;
  private int maxInvitee;
  private boolean showRemain;
  private boolean exceptEvents;
  private boolean exceptSchedules;
  private int order;
  private boolean secret;
  private boolean active;
  private boolean shared;
  private boolean deleted;
  private int schedulesCount;
  private Date createdAt;
  private Date updatedAt;

  private Time time;
  private Survey survey;
  private Alarm alarm;
  private Confirm confirm;

}
