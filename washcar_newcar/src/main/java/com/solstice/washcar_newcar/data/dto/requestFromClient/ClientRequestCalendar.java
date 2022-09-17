package com.solstice.washcar_newcar.data.dto.requestFromClient;

import java.net.URI;
import java.net.URL;

import org.springframework.web.util.UriBuilder;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestAlarm;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUser;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientRequestCalendar {
  private String name;
  private String slug;
  private String description;

  public WhattimeRequestCalendar toWhattimeCalendarDto(WhattimeUser whattimeUser) {

    return new WhattimeRequestCalendar(
        "https://whattime.co.kr/" + whattimeUser.getSlug() + "/" + slug,
        name,
        slug,
        description);
  }

}