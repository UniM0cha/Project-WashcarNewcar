package com.solstice.washcar_newcar.data.whattime;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WhattimeUser {
  private String uri;
  private String code;
  private String email;
  private String role;
  private String name;
  private String slug;
  private String homeUrl;
  private String message;
  private String timeZone;
  private String imgUrl;
  private String logoUrl;
  private String shareImgUrl;
  private Date updatedAt;
  private Date createdAt;
}
