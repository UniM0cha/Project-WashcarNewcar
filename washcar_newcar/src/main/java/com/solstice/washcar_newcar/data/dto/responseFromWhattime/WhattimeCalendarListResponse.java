package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class WhattimeCalendarListResponse {
  private ArrayList<WhattimeCalendar> collection;
}
