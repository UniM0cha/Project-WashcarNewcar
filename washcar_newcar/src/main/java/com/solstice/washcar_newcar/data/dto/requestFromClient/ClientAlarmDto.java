package com.solstice.washcar_newcar.data.dto.requestFromClient;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeAlarm;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientAlarmDto {
  private boolean emailGuest;
  private boolean smsGuest;
  private boolean kakaoGuest;
  private boolean smsGuestReminder;
  private int smsGuestReminderDuration;
  private String smsGuestReminderDurationKind;
  private boolean kakaoGuestReminder;
  private int kakaoGuestReminderDuration;
  private String kakaoGuestReminderDurationKind;
  private boolean emailHost;
  private boolean smsHost;
  private boolean kakaoHost;
  private String hostAlarmKind;
  private boolean cancelReschedule;
  private String cancelPolicy;

  public WhattimeAlarm toAlarm() {
    return WhattimeAlarm.builder()
        .emailGuest(emailGuest)
        .smsGuest(smsGuest)
        .kakaoGuest(kakaoGuest)
        .smsGuestReminder(smsGuestReminder)
        .smsGuestReminderDuration(smsGuestReminderDuration)
        .smsGuestReminderDurationKind(smsGuestReminderDurationKind)
        .kakaoGuestReminder(kakaoGuestReminder)
        .kakaoGuestReminderDuration(kakaoGuestReminderDuration)
        .kakaoGuestReminderDurationKind(kakaoGuestReminderDurationKind)
        .emailHost(emailHost)
        .smsHost(smsHost)
        .kakaoHost(kakaoHost)
        .hostAlarmKind(hostAlarmKind)
        .cancelReschedule(cancelReschedule)
        .cancelPolicy(cancelPolicy)
        .build();
  }
}
