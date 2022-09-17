package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import java.util.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class WhattimeTime {
  private String rangeKind;
  private Date rangeStart;
  private Date rangeEnd;
  private int rangeAfterDay;
  private String rangeAfterDayKind;
  private int duration;
  private String durationKind;
  private int incre;
  private int beforeBuffer;
  private int afterBuffer;
  private int beforeCalendarBuffer;
  private int afterCalendarBuffer;
  private int prepare;
  private String prepareKind;
  private String guestMinTime;
  private String guestMinTimeKind;
}
