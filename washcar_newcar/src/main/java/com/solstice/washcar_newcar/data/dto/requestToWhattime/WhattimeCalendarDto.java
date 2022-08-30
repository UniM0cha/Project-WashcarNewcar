package com.solstice.washcar_newcar.data.dto.requestToWhattime;

import java.net.URI;
import java.net.URL;

import org.springframework.web.util.UriBuilder;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUser;

import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class WhattimeCalendarDto {
  private String name;
  private String slug;
  private String color;
  private String description;

  private WhattimeTimeDto time;
  private WhattimeSurveyDto survey;
  private WhattimeAlarmDto alarm;
  private WhattimeConfirmDto confirm;
}