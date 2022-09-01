package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestQuestion;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeQuestion;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeSurvey;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientRequestQuestion {
  private String title;
  private String kind;
  private boolean required;
  private boolean on;

  public WhattimeRequestQuestion toWhattimeRequestQuestion() {
    return new WhattimeRequestQuestion(title, kind, required, on);
  }
}
