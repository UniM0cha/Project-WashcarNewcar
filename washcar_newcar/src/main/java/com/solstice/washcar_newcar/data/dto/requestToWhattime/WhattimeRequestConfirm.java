package com.solstice.washcar_newcar.data.dto.requestToWhattime;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeConfirm;

import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class WhattimeRequestConfirm {
  private String confirmKind;
  private boolean confirmWaiting;
  private String confirmWaitingMessage;
  private boolean emailPublic;
  private boolean phonePublic;
  private String phone;

  // public WhattimeConfirm toConfirm() {
  // return WhattimeConfirm.builder()
  // .confirmKind(confirmKind)
  // .confirmWaiting(confirmWaiting)
  // .confirmWaitingMessage(confirmWaitingMessage)
  // .emailPublic(emailPublic)
  // .phonePublic(phonePublic)
  // .phone(phone)
  // .build();
  // }

}
