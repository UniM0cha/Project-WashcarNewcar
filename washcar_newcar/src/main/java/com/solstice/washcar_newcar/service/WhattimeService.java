package com.solstice.washcar_newcar.service;

import java.util.ArrayList;

import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientCalendarDto;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientStoreDto;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUser;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;

public interface WhattimeService {

  public Store register(User user, ClientStoreDto clientStoreDto);

  public WhattimeUser getWhattimeUserFromStore(Store store);

  public WhattimeCalendar createCalendar(ClientCalendarDto clientCalendarDto, WhattimeUser whattimeUser);

  public WhattimeCalendar getCalendar(String code);

  public ArrayList<WhattimeCalendar> getAllCalendar(Store store);
}
