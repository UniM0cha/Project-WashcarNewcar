package com.solstice.washcar_newcar.controller;

import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solstice.washcar_newcar.config.security.auth.OAuth2UserDetails;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

  @PostMapping("/check")
  public boolean checkLogin(@Parameter(hidden = true) @AuthenticationPrincipal OAuth2UserDetails oAuth2UserDetails) {
    if (oAuth2UserDetails != null) {
      log.info(
          "로그인 체크 : 유저ID=" + oAuth2UserDetails.getUsername());
      return true;
    } else {
      log.error(
          "데이터베이스에 유저가 존재하지 않음");
      return false;
    }
  }
}
