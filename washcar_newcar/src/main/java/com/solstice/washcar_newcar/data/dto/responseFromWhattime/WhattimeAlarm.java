package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class WhattimeAlarm {
  // 이메일 게스트 전송 여부
  private boolean emailGuest;

  // SMS 게스트 전송 여부
  private boolean smsGuest;

  // 알림톡 게스트 전송 여부
  private boolean kakaoGuest;

  // SMS 게스트 리마인더 여부
  private boolean smsGuestReminder;

  // SMS 리마인더 시간 설정, 15분~48시간
  private int smsGuestReminderDuration;

  // SMS 리마인더 시간 종류
  // hour - 시간
  // minute - 분
  private String smsGuestReminderDurationKind;

  // 알림톡 게스트 리마인더 여부
  private boolean kakaoGuestReminder;

  // 알림톡 리마인더 시간 설정, 15분~48시간
  private int kakaoGuestReminderDuration;

  // 알림톡 리마인더 시간 종류
  // hour - 시간
  // minute - 분
  private String kakaoGuestReminderDurationKind;

  // 이메일 호스트 전송 여부
  private boolean emailHost;

  // SMS 호스트 전송 여부
  private boolean smsHost;

  // 알림톡 호스트 전송 여부
  private boolean kakaoHost;

  // 알림 받을 호스트 종류
  // participant - 예약 페이지 참여자
  // team - 팀 전체
  private String hostAlarmKind;

  // 취소 변경 가능 여부
  private boolean cancelReschedule;

  // 취소 정책
  private String cancelPolicy;

}
