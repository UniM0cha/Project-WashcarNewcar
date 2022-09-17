package com.solstice.washcar_newcar.data.dto.requestFromClient;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.solstice.washcar_newcar.data.dto.requestToWhattime.WhattimeRequestBase;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClientRequestBase {
  private String code;
  private String name;
  private String slug;
  private String description;

  public WhattimeRequestBase toWhattimeRequestBase() {
    return new WhattimeRequestBase(code, name, slug, description);
  }

  /**
   * code string
   * nullable: true
   * 예약 페이지 코드
   * 
   * url string($uri)
   * nullable: true
   * example: https://whattime.co.kr/{user_slug}/{slug}
   * 예약 페이지 주소
   * 
   * name string
   * nullable: true
   * example: 1시간 예약
   * slug string
   * nullable: true
   * example: test
   * 단축 이름
   * 
   * color string
   * nullable: true
   * example: tangerine
   * 구별 색깔
   * 
   * Enum:
   * Array [ 11 ]
   * description string
   * nullable: true
   * example: null
   * 예약 페이지 설명 (HTML)
   * 
   * max_invitee integer($int32)
   * nullable: true
   * example: 10
   * 최대 정원수 (그룹 예약)
   * 
   * show_remain boolean
   * nullable: true
   * 잔여 횟수 노출 (그룹 예약)
   * 
   * order integer($int32)
   * nullable: true
   * 우선순위
   * 
   * secret boolean
   * nullable: true
   * example: false
   * 일정 예약 숨기기
   * 
   * active boolean
   * nullable: true
   * 활성화 여부
   */
}
