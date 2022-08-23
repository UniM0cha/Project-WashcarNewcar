package com.solstice.washcar_newcar.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solstice.washcar_newcar.config.security.auth.OAuth2UserDetails;
import com.solstice.washcar_newcar.data.dto.CalendarDto;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.service.WhattimeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
@RequiredArgsConstructor
public class ProducerController {

  private final WhattimeService whattimeService;

  @PostMapping("/calendar")
  public CalendarDto createCalendar(@RequestBody CalendarDto calendarDto) {
    log.info(calendarDto.toString());
    whattimeService.createCalendar(calendarDto);
    return calendarDto;
  }

  @PostMapping("/slug")
  public String getUserSlug(@AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails,
      @RequestBody CalendarDto calendarDto) {
    log.info(oAuth2UserDetails.getUsername());
    User user = oAuth2UserDetails.getUser();
    whattimeService.getUserSlug(user);
    return "ok";
  }

}
