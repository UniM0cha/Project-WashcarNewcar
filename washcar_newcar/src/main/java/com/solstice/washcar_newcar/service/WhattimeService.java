package com.solstice.washcar_newcar.service;

import java.util.ArrayList;

import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestBase;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestCalendar;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestConfirm;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestStore;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestSurvey;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestTime;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUser;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;

public interface WhattimeService {

  public Store register(User user, ClientRequestStore clientStoreDto);

  public WhattimeUser getWhattimeUserFromStore(Store store);

  /**
   * @param clientCalendar
   * @param whattimeUser
   * @return 캘린더를 생성한 후 캘린더 코드 반환
   */
  public WhattimeCalendar createCalendar(ClientRequestCalendar clientCalendar, WhattimeUser whattimeUser);

  public WhattimeCalendar updateCalendarBase(ClientRequestBase clientRequestBaseDto);

  public WhattimeCalendar updateCalendarTime(ClientRequestTime clientRequestTime);

  public WhattimeCalendar updateCalendarSurvey(ClientRequestSurvey clientRequestSurvey);

  public WhattimeCalendar updateCalendarConfirm(ClientRequestConfirm clientRequestConfirm);
}
