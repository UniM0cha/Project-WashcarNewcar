package com.solstice.washcar_newcar.data.dto.requestToWhattime;

import java.sql.Date;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
public class WhattimeRequestTime {
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

  /**
   * range_kind string
   * 선택 가능한 날짜 범위
   * after_day - N일후
   * date_range - 시간 범위
   * infinite - 무제한
   * Enum:
   * Array [ 3 ]
   * 
   * range_start string($date)
   * nullable: true
   * 가능한 시간 시작
   * 
   * range_end string($date)
   * nullable: true
   * 가능한 시간 종료
   * 
   * range_after_day number($int32)
   * nullable: true
   * N일후, 최대 1000일 까지
   * 
   * range_after_day_kind string
   * nullable: true
   * N일후 기준 타입
   * calendar_day - 캘린더 날짜 기준
   * business_day - 영업일 기준
   * Enum:
   * Array [ 2 ]
   * 
   * duration integer($int32)
   * 예약 일정 길이, 5분~12시간
   * 
   * duration_kind string
   * 일정 길이 시간 종류
   * hour - 시간
   * minute - 분
   * Enum:
   * Array [ 2 ]
   * 
   * incre integer
   * 일정 시작 시각의 간격
   * Enum:
   * Array [ 7 ]
   * 
   * before_buffer integer
   * nullable: true
   * 일정전 시간 비우기
   * Enum:
   * Array [ 10 ]
   * 
   * after_buffer integer
   * nullable: true
   * 일정후 시간 비우기
   * Enum:
   * Array [ 10 ]
   * 
   * before_calendar_buffer integer
   * nullable: true
   * 캘린더 일정전 시간 비우기
   * Enum:
   * Array [ 10 ]
   * 
   * after_calendar_buffer integer
   * nullable: true
   * 캘린더 일정전후시간 비우기
   * Enum:
   * Array [ 10 ]
   * 
   * prepare_kind string
   * nullable: true
   * 일정 준비시간 종류
   * hour - 시간
   * minute - 분
   * Enum:
   * Array [ 2 ]
   * 
   * prepare integer($int32)
   * nullable: true
   * 일정 준비시간
   * 
   * guest_min_time_kind string
   * nullable: true
   * 고객당 최소 예약 가능 시간 종류
   * hour - 시간
   * minute - 분
   * day - 날
   * Enum:
   * Array [ 3 ]
   * 
   * guest_min_time integer($int32)
   * nullable: true
   * 고객당 최소 예약 가능 시간
   */
}
