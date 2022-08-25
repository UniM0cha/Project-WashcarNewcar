package com.solstice.washcar_newcar.data.whattime;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Survey {
  private boolean emailRequired;
  private boolean phoneRequired;
  private List<Question> questions;
}
