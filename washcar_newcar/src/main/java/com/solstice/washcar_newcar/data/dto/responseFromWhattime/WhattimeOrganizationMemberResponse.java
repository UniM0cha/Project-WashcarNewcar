package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WhattimeOrganizationMemberResponse {
  private WhattimeOrganizationMember resource;
}
