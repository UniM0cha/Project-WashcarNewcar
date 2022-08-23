package com.solstice.washcar_newcar.service;

import java.net.http.HttpClient;
import java.util.HashMap;

import org.aspectj.apache.bcel.generic.ObjectType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.solstice.washcar_newcar.data.dto.CalendarDto;
import com.solstice.washcar_newcar.data.entity.User;

public interface WhattimeService {

  /**
   * 가입하기
   * 유저 정보(이메일)를 매개변수로 받아서 Whattime에 회원가입을 진행한다.
   * 그후 organization_id를 받아와 user 객체에 삽입한다.
   */
  public User register(User user);

  /**
   * UserSlug 가져오기
   * 캘린더 생성에 필요한 user_slug를 반환하는 함수
   */
  public String getUserSlug(User user);

  /**
   * 캘린더 만들기
   * 캘린더 만들 때 필요한 것: user_slug, slug, name, description,
   * organization_id를 매개변수로 받아서 예약페이지(캘린더)를 생성한다.
   */
  public String createCalendar(CalendarDto calendar);
}
