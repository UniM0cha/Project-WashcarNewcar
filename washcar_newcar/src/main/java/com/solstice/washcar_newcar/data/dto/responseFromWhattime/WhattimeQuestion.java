package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class WhattimeQuestion {
  private String title;
  private String kind;
  private boolean required;
  private boolean on;
}
