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
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.whattime.Calendar;
import com.solstice.washcar_newcar.data.whattime.WhattimeUser;
import com.solstice.washcar_newcar.service.WhattimeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1")
@Slf4j
@RequiredArgsConstructor
public class ProviderController {

  private final WhattimeService whattimeService;

  @PostMapping("/calendar")
  public String createCalendar(@AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails,
      @RequestBody Calendar calendar) {
    log.info(calendar.toString());
    User user = oAuth2UserDetails.getUser();
    WhattimeUser whattimeUser = whattimeService.getWhattimeUserFromUser(user);
    String result = whattimeService.createCalendar(calendar, whattimeUser);
    return result;
  }

  @PostMapping("/user")
  public WhattimeUser getUserSlug(@AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails,
      @RequestBody Calendar calendarDto) {
    log.info(oAuth2UserDetails.getUsername());
    User user = oAuth2UserDetails.getUser();
    WhattimeUser whattimeUser = whattimeService.getWhattimeUserFromUser(user);
    return whattimeUser;
  }

  @GetMapping("/calendar")
  public String getCalendar() {
    whattimeService.getCalendar("vMrtvJM19X");
    return "ok";
  }

}
