package com.solstice.washcar_newcar.data.dto.requestToWhattime;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeConfirm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
public class WhattimeRequestConfirm {
  private String code;
  private String confirmKind;
  private boolean confirmWaiting;
  private String confirmWaitingMessage;
  private boolean emailPublic;
  private boolean phonePublic;
  private String phone;
}
