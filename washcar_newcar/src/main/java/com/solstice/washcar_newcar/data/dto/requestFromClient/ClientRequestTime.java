package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.sql.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestTime;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeTime;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientRequestTime {
  private String code;
  private String rangeKind;
  private Date rangeStart;
  private Date rangeEnd;
  private Integer rangeAfterDay;
  private String rangeAfterDayKind;
  private Integer duration;
  private String durationKind;
  private Integer incre;
  private Integer beforeBuffer;
  private Integer afterBuffer;
  private Integer beforeCalendarBuffer;
  private Integer afterCalendarBuffer;
  private Integer prepare;
  private String prepareKind;
  private String guestMinTime;
  private String guestMinTimeKind;

  public WhattimeRequestTime toWhattimeRequestTime() {
    return new WhattimeRequestTime(code, rangeKind, rangeStart, rangeEnd, rangeAfterDay, rangeAfterDayKind, duration,
        durationKind, incre, beforeBuffer, afterBuffer, beforeCalendarBuffer, afterCalendarBuffer, prepare, prepareKind,
        guestMinTime, guestMinTimeKind);
  }
}
