package com.solstice.washcar_newcar.data.whattime;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CalendarListResponse {
  private ArrayList<Calendar> collection;
}
