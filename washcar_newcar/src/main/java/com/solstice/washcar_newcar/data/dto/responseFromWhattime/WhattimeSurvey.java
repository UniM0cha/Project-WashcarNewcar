package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class WhattimeSurvey {
  private boolean emailRequired;
  private boolean phoneRequired;
  private List<WhattimeQuestion> questions;
}
