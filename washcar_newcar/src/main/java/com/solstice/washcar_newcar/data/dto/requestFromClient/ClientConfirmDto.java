package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeConfirm;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientConfirmDto {
  private String confirmKind;
  private String confirmUrl;
  private boolean confirmPassParams;
  private boolean confirmWaiting;
  private String confirmWaitingMessage;
  private boolean emailPublic;
  private boolean phonePublic;
  private String phone;

  public WhattimeConfirm toConfirm() {
    return WhattimeConfirm.builder()
        .confirmKind(confirmKind)
        .confirmUrl(confirmUrl)
        .confirmPassParams(confirmPassParams)
        .confirmWaiting(confirmWaiting)
        .confirmWaitingMessage(confirmWaitingMessage)
        .emailPublic(emailPublic)
        .phonePublic(phonePublic)
        .phone(phone)
        .build();
  }

}
