package com.solstice.washcar_newcar.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestBase;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestCalendar;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestConfirm;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestStore;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestSurvey;
import com.solstice.washcar_newcar.data.dto.requestFromClient.ClientRequestTime;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestAlarm;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestBase;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestCalendar;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestConfirm;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestSurvey;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestTime;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendar;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeCalendarResponse;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUser;
import com.solstice.washcar_newcar.data.dto.responseFromWhattime.WhattimeUserResponse;
import com.solstice.washcar_newcar.data.entity.Location;
import com.solstice.washcar_newcar.data.entity.Menu;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.StoreImage;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.repository.LocationRepository;
import com.solstice.washcar_newcar.data.repository.MenuRepository;
import com.solstice.washcar_newcar.data.repository.StoreImageRepository;
import com.solstice.washcar_newcar.data.repository.StoreRepository;
import com.solstice.washcar_newcar.service.WhattimeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class WhattimeServiceImpl implements WhattimeService {

  private final WebClient webClientWithToken;
  private final StoreRepository storeRepository;
  private final StoreImageRepository storeImageRepository;
  private final LocationRepository locationRepository;
  private final MenuRepository menuRepository;

  @Override
  public Store register(User user, ClientRequestStore storeRegisterDto) {

    Store foundStore = storeRepository.findByUser(user);
    if (foundStore != null) {
      log.error("중복된 매장 생성 요청입니다.");
      return foundStore;
    }

    /**
     * user 정보를 바탕으로 Whattime에 회원가입.
     * 회원가입 후 Whattime User Code를 반환한다.
     */
    String whattimeuserCode = "MvMemAB7y8";

    // Store(부모) 먼저 저장
    Store whattimeRegisteredStore = storeRegisterDto.whattimeRegister(user, whattimeuserCode);
    Store savedStore = storeRepository.save(whattimeRegisteredStore);

    // 나머지(자식) 저장
    log.info("DTO 객체에서 엔티티로 변환하면서 store 객체 주입");
    List<StoreImage> storeImages = storeRegisterDto.getStoreImages().stream()
        .map((storeImage) -> storeImage.toEntity(savedStore))
        .toList();
    storeImageRepository.saveAll(storeImages);

    List<Menu> menus = storeRegisterDto.getMenus().stream()
        .map((menu) -> menu.toEntity(savedStore)).toList();
    menuRepository.saveAll(menus);

    Location location = storeRegisterDto.getLocation().toEntity(savedStore);
    locationRepository.save(location);

    log.info("Whattime 회원가입 후 받은 user_code : " + savedStore.getWhattimeUserCode());
    return savedStore;
  }

  @Override
  public WhattimeUser getWhattimeUserFromStore(Store store) {

    if (store.getWhattimeUserCode() == null) {
      log.error("Store 객체에 Whattime user code가 없음");
      return null;
    }

    WhattimeUserResponse response = webClientWithToken.get()
        .uri("/users/{code}", store.getWhattimeUserCode())
        .retrieve()
        .bodyToMono(WhattimeUserResponse.class)
        .block();

    log.info("getWhattimeUserFromStore : " + response.toString());

    return response.getResource();
  }

  @Override
  public WhattimeCalendar createCalendar(ClientRequestCalendar clientRequestCalendar, WhattimeUser whattimeUser) {

    WhattimeRequestCalendar whattimeCalendarDto = clientRequestCalendar.toWhattimeCalendarDto(whattimeUser);
    log.info("Whattime으로 보낼 값 : " + whattimeCalendarDto.toString());

    WhattimeCalendarResponse response = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(whattimeCalendarDto)
        .retrieve().bodyToMono(WhattimeCalendarResponse.class).block();

    WhattimeRequestAlarm whattimeRequestAlarm = new WhattimeRequestAlarm(
        response.getResource().getCode(),
        false,
        true,
        true,
        true,
        1,
        "hour",
        true,
        1,
        "hour",
        false,
        true,
        true,
        null,
        false,
        null);

    webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(whattimeRequestAlarm)
        .retrieve().bodyToMono(WhattimeCalendarResponse.class).block();

    log.info("캘린더 생성 후 반환 값 : " + response.getResource().toString());

    WhattimeCalendar calendar = response.getResource();
    return calendar;
  }

  @Override
  public WhattimeCalendar updateCalendarBase(ClientRequestBase clientRequestBaseDto) {
    WhattimeRequestBase whattimeRequestBase = clientRequestBaseDto.toWhattimeRequestBase();

    WhattimeCalendarResponse response = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(whattimeRequestBase)
        .retrieve().bodyToMono(WhattimeCalendarResponse.class).block();

    return response.getResource();
  }

  @Override
  public WhattimeCalendar updateCalendarTime(ClientRequestTime clientRequestTime) {
    WhattimeRequestTime whattimeRequestTime = clientRequestTime.toWhattimeRequestTime();

    WhattimeCalendarResponse response = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(whattimeRequestTime)
        .retrieve().bodyToMono(WhattimeCalendarResponse.class).block();

    return response.getResource();
  }

  @Override
  public WhattimeCalendar updateCalendarSurvey(ClientRequestSurvey clientRequestSurvey) {
    WhattimeRequestSurvey whattimeRequestSurvey = clientRequestSurvey.toWhattimeRequestSurvey();

    WhattimeCalendarResponse response = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(whattimeRequestSurvey)
        .retrieve().bodyToMono(WhattimeCalendarResponse.class).block();

    return response.getResource();
  }

  @Override
  public WhattimeCalendar updateCalendarConfirm(ClientRequestConfirm clientRequestConfirm) {
    WhattimeRequestConfirm whattimeRequestConfirm = clientRequestConfirm.toWhattimeRequestConfirm();

    WhattimeCalendarResponse response = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(whattimeRequestConfirm)
        .retrieve().bodyToMono(WhattimeCalendarResponse.class).block();

    return response.getResource();
  }
}
