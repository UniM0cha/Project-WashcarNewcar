package com.solstice.washcar_newcar.service.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoProperties.Storage;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.solstice.washcar_newcar.data.dto.StoreRegisterDto;
import com.solstice.washcar_newcar.data.entity.Location;
import com.solstice.washcar_newcar.data.entity.Menu;
import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.StoreImage;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.repository.LocationRepository;
import com.solstice.washcar_newcar.data.repository.MenuRepository;
import com.solstice.washcar_newcar.data.repository.StoreImageRepository;
import com.solstice.washcar_newcar.data.repository.StoreRepository;
import com.solstice.washcar_newcar.data.whattime.Calendar;
import com.solstice.washcar_newcar.data.whattime.CalendarListResponse;
import com.solstice.washcar_newcar.data.whattime.CalendarResponse;
import com.solstice.washcar_newcar.data.whattime.OrganizationMember;
import com.solstice.washcar_newcar.data.whattime.OrganizationMemberResponse;
import com.solstice.washcar_newcar.data.whattime.WhattimeUser;
import com.solstice.washcar_newcar.data.whattime.WhattimeUserResponse;
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
  public Store register(User user, StoreRegisterDto storeRegisterDto) {
    log.info("매장 생성 => Whattime 회원가입 요청");

    /**
     * user 정보를 바탕으로 Whattime에 회원가입.
     * 회원가입 후 Whattime User Code를 반환한다.
     */
    String whattimeuserCode = "MvMemAB7y8";

    // DTO에 있는 StoreImage 객체 배열을 엔티티 StoreImage 객체 배열로 변환
    // List<StoreImage> storeImages = new ArrayList<>();
    // storeRegisterDto.getStoreImages().forEach(storeImage ->
    // storeImages.add(storeImage.toEntity()));

    List<StoreImage> storeImages = storeRegisterDto.getStoreImages().stream()
        .map((storeImage) -> storeImage.toEntity())
        .toList();

    List<Menu> menus = storeRegisterDto.getMenus().stream()
        .map((menu) -> menu.toEntity()).toList();

    Location location = storeRegisterDto.getLocation().toEntity();

    Store whattimeRegisteredStore = Store.builder()
        .name(storeRegisterDto.getName())
        .profileImage(storeRegisterDto.getProfileImage())
        .info(storeRegisterDto.getInfo())
        .storeImages(storeImages)
        .location(location)
        .menus(menus)
        .user(user)
        .whattimeUserCode(whattimeuserCode)
        .build();

    storeRepository.save(whattimeRegisteredStore);

    List<StoreImage> storeImages = store.getStoreImages();
    List<StoreImage> savedStoreImages = storeImageRepository.saveAll(storeImages);

    Location location = store.getLocation();
    Location savedLocation = locationRepository.save(location);

    List<Menu> menus = store.getMenus();
    List<Menu> savedMenus = menuRepository.saveAll(menus);

    log.info("Whattime 회원가입 후 받은 user_code : " + whattimeRegisteredStore.getWhattimeUserCode());
    return whattimeRegisteredStore;
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

    log.info("getWhattimeUserFromStore :");
    log.info(response.toString());

    return response.getResource();
  }

  @Override
  public Calendar createCalendar(Calendar calendar, WhattimeUser whattimeUser) {

    CalendarResponse response = webClientWithToken.post()
        .uri("/calendars/upsert")
        .bodyValue(calendar)
        .retrieve().bodyToMono(CalendarResponse.class).block();

    log.info("createCalendar :");
    log.info(response.getResource().toString());

    return response.getResource();
  }

  @Override
  public Calendar getCalendar(String code) {
    CalendarResponse response = webClientWithToken.get()
        .uri("/calendars/{code}", code)
        .retrieve()
        .bodyToMono(CalendarResponse.class)
        .block();

    log.info(response.getResource().toString());

    return response.getResource();
  }

  @Override
  public ArrayList<Calendar> getAllCalendar(Store store) {
    String whattimeUserCode = store.getWhattimeUserCode();
    CalendarListResponse response = webClientWithToken.get()
        .uri(uriBuilder -> uriBuilder.path("/calendars")
            .queryParam("user", "https://api.whattime.co.kr/v1/users/" + whattimeUserCode).build())
        .retrieve()
        .bodyToMono(CalendarListResponse.class)
        .block();
    return response.getCollection();
  }

}
