package com.solstice.washcar_newcar.service;

import java.net.http.HttpClient;
import java.util.HashMap;

import org.aspectj.apache.bcel.generic.ObjectType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

public interface WhattimeService {

  /**
   * 가입하기
   * 유저 정보(이메일)를 매개변수로 받아서 Whattime에 회원가입을 진행한다.
   * 그후 organization_id를 반환한다.
   */
  public String register(String email);

  /**
   * 캘린더 만들기
   * organization_id를 매개변수로 받아서 예약페이지(캘린더)를 생성한다.
   */
  public String createCalendar(String organizationId);
}
