package com.solstice.washcar_newcar.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

  @PostMapping("/check")
  public boolean checkLogin(@AuthenticationPrincipal OAuth2User principal) {
    log.info(principal.toString());
    return true;
  }

  @GetMapping("/check")
  public boolean getCheckLogin(@AuthenticationPrincipal OAuth2User principal) {
    log.info(principal.toString());
    return true;
  }
}
