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
import com.solstice.washcar_newcar.data.dto.StoreRegisterDto;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.whattime.Calendar;
import com.solstice.washcar_newcar.data.whattime.WhattimeUser;
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

  @PostMapping("/register")
  public String register(@Parameter(hidden = true) @AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails,
      @RequestBody StoreRegisterDto storeRegisterDto) {
    log.info(storeRegisterDto.toString());
    User user = oAuth2UserDetails.getUser();
    Store newStore = whattimeService.register(user, storeRegisterDto);
    return newStore.getWhattimeUserCode();
  }

  // @PostMapping("/calendar")
  // public Calendar createCalendar(@Parameter(hidden = true)
  // @AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails,
  // @RequestBody Calendar calendar) {
  // log.info(calendar.toString());
  // User user = oAuth2UserDetails.getUser();
  // Store store = user.getStore();
  // WhattimeUser whattimeUser = whattimeService.getWhattimeUserFromStore(store);
  // Calendar newCalendar = whattimeService.createCalendar(calendar,
  // whattimeUser);
  // return newCalendar;
  // }

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
