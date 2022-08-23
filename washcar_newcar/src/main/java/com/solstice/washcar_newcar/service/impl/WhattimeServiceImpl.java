package com.solstice.washcar_newcar.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.solstice.washcar_newcar.data.dto.CalendarDto;
import com.solstice.washcar_newcar.data.entity.User;
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
  public String getUserSlug(User user) {

    if (user.getOrganizationCode() == null) {
      return null;
    }

    String result = webClientWithToken.get()
        .uri("/organization_members/{organization_code}", user.getOrganizationCode())
        .retrieve()
        .bodyToMono(String.class)
        .block();

    log.info(result);
    return result;
  }

  @Override
  public String createCalendar(CalendarDto calendar) {
    String result = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(calendar)
        .retrieve().bodyToMono(String.class).block();
    return null;
  }

}
