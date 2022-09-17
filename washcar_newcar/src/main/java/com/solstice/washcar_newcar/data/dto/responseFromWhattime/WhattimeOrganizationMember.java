package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WhattimeOrganizationMember {
  private String uri;
  private String code;
  private String role;
  private String approve;
  private Date updateAt;
  private Date createdAt;

  private WhattimeUser user;
}
