package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestConfirm;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeConfirm;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientRequestConfirm {
  private String phone;

  public WhattimeRequestConfirm toWhattimeConfirmDto() {
    return WhattimeRequestConfirm.builder()
        .confirmKind("normal")
        .confirmWaiting(true)
        .confirmWaitingMessage("잠시 기다려주세요.")
        .emailPublic(true)
        .phonePublic(true)
        .phone(phone)
        .build();
  }

}
