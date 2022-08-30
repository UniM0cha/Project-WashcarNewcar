package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.net.URI;
import java.net.URL;

import org.springframework.web.util.UriBuilder;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeCalendarDto;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUser;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientCalendarDto {
  private String name;
  private String slug;
  private String color;
  private String description;

  private ClientTimeDto time;
  private ClientSurveyDto survey;
  private ClientAlarmDto alarm;
  private ClientConfirmDto confirm;

  public WhattimeCalendar toCalendar(WhattimeUser whattimeUser) {

    return WhattimeCalendar.builder()
        .code(null)
        .url("https://whattime.co.kr/" + whattimeUser.getSlug() + "/" + this.slug)
        .name(this.name)
        .slug(this.slug)
        .color(this.color)
        .description(this.description)
        .time(this.time.toTime())
        .survey(this.survey.toServey())
        .alarm(this.alarm.toAlarm())
        .confirm(this.confirm.toConfirm())
        .build();
  }

  public WhattimeCalendarDto toWhattimeCalendarDto(WhattimeUser whattimeUser) {

  }

}