package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import java.util.Calendar;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WhattimeCalendars {
  private List<WhattimeCalendar> collection;
}
