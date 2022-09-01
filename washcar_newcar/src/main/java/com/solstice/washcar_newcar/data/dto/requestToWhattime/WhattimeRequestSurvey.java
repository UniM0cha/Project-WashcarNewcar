package com.solstice.washcar_newcar.data.dto.requestToWhattime;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeSurvey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
public class WhattimeRequestSurvey {
  private boolean emailRequired;
  private boolean phoneRequired;
  private List<WhattimeRequestQuestion> questions;
}
