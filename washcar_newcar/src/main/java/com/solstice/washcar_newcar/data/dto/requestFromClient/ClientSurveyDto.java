package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeSurvey;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientSurveyDto {
  private boolean emailRequired;
  private boolean phoneRequired;
  private List<ClientQuestionDto> questions;

  public WhattimeSurvey toServey() {
    return WhattimeSurvey.builder()
        .emailRequired(this.emailRequired)
        .phoneRequired(this.phoneRequired)
        .questions(this.questions.stream().map((question) -> question.toQuestion()).toList())
        .build();
  }

}
