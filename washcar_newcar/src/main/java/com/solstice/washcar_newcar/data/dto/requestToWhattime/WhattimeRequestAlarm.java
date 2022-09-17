package com.solstice.washcar_newcar.data.dto.requestToWhattime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeAlarm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@AllArgsConstructor
public class WhattimeRequestAlarm {
  private String code;
  private Boolean emailGuest;
  private Boolean smsGuest;
  private Boolean kakaoGuest;
  private Boolean smsGuestReminder;
  private Integer smsGuestReminderDuration;
  private String smsGuestReminderDurationKind;
  private Boolean kakaoGuestReminder;
  private Integer kakaoGuestReminderDuration;
  private String kakaoGuestReminderDurationKind;
  private Boolean emailHost;
  private Boolean smsHost;
  private Boolean kakaoHost;
  private String hostAlarmKind;
  private Boolean cancelReschedule;
  private String cancelPolicy;

  /**
   * email_guest boolean
   * 이메일 게스트 전송 여부
   * 
   * sms_guest boolean
   * SMS 게스트 전송 여부
   * 
   * kakao_guest boolean
   * 알림톡 게스트 전송 여부
   * 
   * sms_guest_reminder boolean
   * SMS 게스트 리마인더 여부
   * 
   * sms_guest_reminder_duration integer($int32)
   * SMS 리마인더 시간 설정, 15분~48시간
   * 
   * sms_guest_reminder_duration_kind string
   * SMS 리마인더 시간 종류
   * hour - 시간
   * minute - 분
   * Enum:
   * Array [ 2 ]
   * 
   * kakao_guest_reminder boolean
   * 알림톡 게스트 리마인더 여부
   * 
   * kakao_guest_reminder_duration integer($int32)
   * 알림톡 리마인더 시간 설정, 15분~48시간
   * 
   * kakao_guest_reminder_duration_kind string
   * 알림톡 리마인더 시간 종류
   * hour - 시간
   * minute - 분
   * Enum:
   * Array [ 2 ]
   * 
   * email_host boolean
   * 이메일 호스트 전송 여부
   * 
   * sms_host boolean
   * SMS 호스트 전송 여부
   * 
   * kakao_host boolean
   * 알림톡 호스트 전송 여부
   * 
   * host_alarm_kind string
   * nullable: true
   * 알림 받을 호스트 종류
   * 
   * participant - 예약 페이지 참여자
   * team - 팀 전체
   * Enum:
   * Array [ 2 ]
   * 
   * cancel_reschedule boolean
   * 취소 변경 가능 여부
   * 
   * cancel_policy string
   * nullable: true
   * 취소 정책
   */
}
