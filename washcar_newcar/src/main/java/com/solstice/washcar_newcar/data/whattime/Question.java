package com.solstice.washcar_newcar.data.whattime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Question {
  private String title;
  private String kind;
  private boolean required;
  private boolean on;
}
