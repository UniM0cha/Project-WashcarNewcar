package com.solstice.washcar_newcar.service;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.HashMap;

import org.aspectj.apache.bcel.generic.ObjectType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.whattime.Calendar;
import com.solstice.washcar_newcar.data.whattime.WhattimeUser;

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
  public WhattimeUser getWhattimeUserFromUser(User user);

  /**
   * 캘린더 만들기
   * 캘린더 만들 때 필요한 것: user_slug, slug, name, description,
   * organization_id를 매개변수로 받아서 예약페이지(캘린더)를 생성한다.
   * 
   * @param calendar     생성할 캘린더 내용이 담긴 캘린더 객체
   * @param whattimeUser 캘린더를 생성할 유저가 담긴 객체
   * @return 캘린더를 생성한 후 만들어진 캘린더 객체
   */
  public Calendar createCalendar(Calendar calendar, WhattimeUser whattimeUser);

  /**
   * 캘린더 정보 가져오기
   * 
   * @param code 캘린더의 코드
   * @return 캘린더 객체
   */
  public Calendar getCalendar(String code);

  public ArrayList<Calendar> getAllCalendar(User user);
}
