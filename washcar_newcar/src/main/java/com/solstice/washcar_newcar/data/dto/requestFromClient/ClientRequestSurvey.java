package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestSurvey;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeSurvey;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientRequestSurvey {
  private List<ClientRequestQuestion> questions;

  public WhattimeRequestSurvey toWhattimeRequestSurvey() {
    return new WhattimeRequestSurvey(
        false,
        true,
        questions.stream().map((question) -> question.toWhattimeRequestQuestion()).toList());
  }

}
