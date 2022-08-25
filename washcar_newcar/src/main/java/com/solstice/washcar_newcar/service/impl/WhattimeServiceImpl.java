package com.solstice.washcar_newcar.service.impl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.whattime.Calendar;
import com.solstice.washcar_newcar.data.whattime.CalendarResponse;
import com.solstice.washcar_newcar.data.whattime.OrganizationMember;
import com.solstice.washcar_newcar.data.whattime.OrganizationMemberResponse;
import com.solstice.washcar_newcar.data.whattime.WhattimeUser;
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
    User newUser = new User(user, "DbqjQqvZaE");
    log.info("Whattime 회원가입 후 받은 organization_id : " + newUser.getOrganizationCode());
    return newUser;
  }

  @Override
  public WhattimeUser getWhattimeUserFromUser(User user) {

    if (user.getOrganizationCode() == null) {
      log.error("User 객체에 organizationCode가 없음");
      return null;
    }

    OrganizationMemberResponse response = webClientWithToken.get()
        .uri("/organization_members/{organization_code}", user.getOrganizationCode())
        .retrieve()
        .bodyToMono(OrganizationMemberResponse.class)
        .block();

    log.info(response.toString());

    return response.getResource().getUser();
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

}
