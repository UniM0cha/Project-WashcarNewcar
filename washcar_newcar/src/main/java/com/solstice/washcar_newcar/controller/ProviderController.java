package com.solstice.washcar_newcar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solstice.washcar_newcar.config.security.auth.OAuth2UserDetails;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientCalendarDto;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientStoreDto;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUser;
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
      @RequestBody ClientStoreDto storeRegisterDto) {
    log.info("매장생성, whattime 회원가입 요청");
    log.info(storeRegisterDto.toString());
    User user = oAuth2UserDetails.getUser();
    Store newStore = whattimeService.register(user, storeRegisterDto);
    return "ok";
  }

  @PostMapping("/calendar")
  public String createCalendar(
      @Parameter(hidden = true) @AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails,
      @RequestBody ClientCalendarDto calendarDto) {
    log.info("캘린더 생성 요청");
    log.info(calendarDto.toString());

    User user = oAuth2UserDetails.getUser();

    // 1. 데이터베이스에서 user를 통해서 store를 불러온다
    Store store = storeService.findByUser(user);
    log.info("user를 통해 가져온 store : " + store.toString());

    // 2. 불러온 store에서 whattimeUser를 가져온다.
    WhattimeUser whattimeUser = whattimeService.getWhattimeUserFromStore(store);

    // 3. 캘린더 생성
    whattimeService.createCalendar(calendarDto, whattimeUser);

    return "ok";
  }

  // @GetMapping("/calendar")
  // public ArrayList<Calendar> getAllCalendar(
  // @Parameter(hidden = true) @AuthenticationPrincipal OAuth2UserDetails
  // oAuth2UserDetails) {
  // User user = oAuth2UserDetails.getUser();
  // ArrayList<Calendar> calendars = whattimeService.getAllCalendar(user);
  // return calendars;
  // }

  // @GetMapping("/calendar/{code}")
  // public Calendar getCalendar(@PathVariable String code) {
  // Calendar calendar = whattimeService.getCalendar(code);
  // return calendar;
  // }

}
