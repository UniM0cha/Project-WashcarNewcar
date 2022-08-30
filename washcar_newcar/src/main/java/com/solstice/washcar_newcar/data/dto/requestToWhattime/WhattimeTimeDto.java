package com.solstice.washcar_newcar.data.dto.requestToWhattime;

import java.sql.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeTime;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WhattimeTimeDto {
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

  public WhattimeTime toTime() {
    return WhattimeTime.builder()
        .rangeKind(this.rangeKind)
        .rangeStart(this.rangeStart)
        .rangeEnd(this.rangeEnd)
        .rangeAfterDay(this.rangeAfterDay)
        .rangeAfterDayKind(this.rangeAfterDayKind)
        .duration(this.duration)
        .durationKind(this.durationKind)
        .incre(this.incre)
        .beforeBuffer(this.beforeBuffer)
        .afterBuffer(this.afterBuffer)
        .beforeCalendarBuffer(this.beforeCalendarBuffer)
        .afterCalendarBuffer(this.afterCalendarBuffer)
        .prepare(this.prepare)
        .prepareKind(this.prepareKind)
        .guestMinTime(this.guestMinTime)
        .guestMinTimeKind(this.guestMinTimeKind)
        .build();
  }
}
