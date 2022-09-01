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
  private String code;
  private String confirmWaitingMessage;
  private String phone;

  public WhattimeRequestConfirm toWhattimeRequestConfirm() {
    return new WhattimeRequestConfirm(
        code,
        "normal",
        true,
        confirmWaitingMessage,
        true,
        true,
        phone);
  }

}
