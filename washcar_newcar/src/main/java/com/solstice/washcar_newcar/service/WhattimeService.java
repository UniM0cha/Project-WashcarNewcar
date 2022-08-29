package com.solstice.washcar_newcar.service;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.HashMap;

import org.aspectj.apache.bcel.generic.ObjectType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.solstice.washcar_newcar.data.dto.StoreRegisterDto;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.whattime.Calendar;
import com.solstice.washcar_newcar.data.whattime.WhattimeUser;

public interface WhattimeService {

  /**
   * Whattime에 가입하기
   */
  public Store register(User user, StoreRegisterDto storeRegisterDto);

  public WhattimeUser getWhattimeUserFromStore(Store store);

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

  public ArrayList<Calendar> getAllCalendar(Store store);
}
