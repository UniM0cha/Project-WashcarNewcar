package com.solstice.washcar_newcar.service.impl;

import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.whattime.Calendar;
import com.solstice.washcar_newcar.data.whattime.CalendarListResponse;
import com.solstice.washcar_newcar.data.whattime.CalendarResponse;
import com.solstice.washcar_newcar.data.whattime.OrganizationMember;
import com.solstice.washcar_newcar.data.whattime.OrganizationMemberResponse;
import com.solstice.washcar_newcar.data.whattime.WhattimeUser;
import com.solstice.washcar_newcar.data.whattime.WhattimeUserResponse;
import com.solstice.washcar_newcar.service.WhattimeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WhattimeServiceImpl implements WhattimeService {

  private final WebClient webClientWithToken;

  @Override
  public User register(User user) {
    log.info("Whattime 회원가입 요청");
    User newUser = new User(user, "MvMemAB7y8");
    log.info("Whattime 회원가입 후 받은 user_code : " + newUser.getUserCode());
    return newUser;
  }

  @Override
  public WhattimeUser getWhattimeUserFromUser(User user) {

    if (user.getUserCode() == null) {
      log.error("User 객체에 userCode가 없음");
      return null;
    }

    WhattimeUserResponse response = webClientWithToken.get()
        .uri("/users/{code}", user.getUserCode())
        .retrieve()
        .bodyToMono(WhattimeUserResponse.class)
        .block();

    log.info(response.toString());

    return response.getResource();
  }

  @Override
  public Calendar createCalendar(Calendar calendar, WhattimeUser whattimeUser) {

    String result = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(calendar)
        .retrieve().bodyToMono(String.class).block();

    log.info(result);

    CalendarResponse response = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(calendar)
        .retrieve().bodyToMono(CalendarResponse.class).block();

    return response.getResource();
  }

  @Override
  public Calendar getCalendar(String code) {
    CalendarResponse response = webClientWithToken.get()
        .uri("/calendars/{code}", code)
        .retrieve()
        .bodyToMono(CalendarResponse.class)
        .block();

    log.info(response.getResource().toString());

    return response.getResource();
  }

  @Override
  public ArrayList<Calendar> getAllCalendar(User user) {
    String userCode = user.getUserCode();
    CalendarListResponse response = webClientWithToken.get()
        .uri(uriBuilder -> uriBuilder.path("/calendars")
            .queryParam("user", "https://api.whattime.co.kr/v1/users/" + userCode).build())
        .retrieve()
        .bodyToMono(CalendarListResponse.class)
        .block();
    return response.getCollection();
  }

}
