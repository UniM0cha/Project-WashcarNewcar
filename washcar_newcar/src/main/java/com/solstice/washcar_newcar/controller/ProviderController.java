package com.solstice.washcar_newcar.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solstice.washcar_newcar.config.security.auth.OAuth2UserDetails;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestBase;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestCalendar;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestConfirm;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestStore;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestSurvey;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestTime;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUser;
import com.solstice.washcar_newcar.data.dto.responseToClient.ClientResponseCalendar;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.service.StoreService;
import com.solstice.washcar_newcar.service.WhattimeService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/provider")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
public class ProviderController {

  private final WhattimeService whattimeService;
  private final StoreService storeService;

  @PostMapping("/register")
  public String register(@Parameter(hidden = true) @AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails,
      @RequestBody ClientRequestStore storeRegisterDto) {
    log.info("매장생성, whattime 회원가입 요청");
    log.info(storeRegisterDto.toString());
    User user = oAuth2UserDetails.getUser();
    Store newStore = whattimeService.register(user, storeRegisterDto);
    return "ok";
  }

  @GetMapping("/calendar")
  public WhattimeCalendar getCalendar() {
    return null;
  }

  @GetMapping("/calendar/list")
  public List<ClientResponseCalendar> getCalendarList(@AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails) {
    User user = oAuth2UserDetails.getUser();
    Store store = storeService.findByUser(user);
    List<ClientResponseCalendar> clientResponseCalendars = whattimeService.getCalendars(store);
    return clientResponseCalendars;
  }

  @PostMapping("/calendar")
  public WhattimeCalendar createCalendar(
      @Parameter(hidden = true) @AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails,
      @RequestBody ClientRequestCalendar clientRequestCalendar) {
    log.info("캘린더 생성 요청");
    User user = oAuth2UserDetails.getUser();
    Store store = storeService.findByUser(user);
    WhattimeUser whattimeUser = whattimeService.getWhattimeUserFromStore(store);
    WhattimeCalendar whattimeCalendar = whattimeService.createCalendar(clientRequestCalendar, whattimeUser);

    log.info("처리가 모두 끝난 후 반환된 코드로 리다이렉트");
    return whattimeCalendar;
  }

  @PostMapping("/calendar/base")
  public WhattimeCalendar updateCalendarBase(@RequestBody ClientRequestBase clientRequestBase) {
    return whattimeService.updateCalendarBase(clientRequestBase);
  }

  @PostMapping("/calendar/time")
  public WhattimeCalendar updateCalendarTime(@RequestBody ClientRequestTime clientRequestTime) {
    return whattimeService.updateCalendarTime(clientRequestTime);
  }

  @PostMapping("/calendar/survey")
  public WhattimeCalendar updateCalendarSurvey(@RequestBody ClientRequestSurvey clientRequestSurvey) {
    return whattimeService.updateCalendarSurvey(clientRequestSurvey);
  }

  @PostMapping("/calendar/confirm")
  public WhattimeCalendar updateCalendarConfirm(@RequestBody ClientRequestConfirm clientRequestConfirm) {
    return whattimeService.updateCalendarConfirm(clientRequestConfirm);
  }
}
