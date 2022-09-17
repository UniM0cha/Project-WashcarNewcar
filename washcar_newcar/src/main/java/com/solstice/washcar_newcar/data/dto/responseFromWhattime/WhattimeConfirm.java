package com.solstice.washcar_newcar.data.dto.responseFromWhattime;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Builder
public class WhattimeConfirm {
  // 예약이 완료되면
  // normal - 예약자 정보, 일정 정보 표시
  // redirect - 다른 웹페이지로 이동
  private String confirmKind;

  // 다른 웹페이지로 이동 버튼
  private List<Object> confirmButtons;

  // 다른 웹페이지로 이동 링크
  private String confirmUrl;

  // 예약 정보를 웹페이지에 파라메터로 전송하기
  private boolean confirmPassParams;

  // 일정 확정 방법
  // false - 예약자가 예약 완료하면 예약 확정
  // true - 주최자가 최종 확정
  private boolean confirmWaiting;

  // 예약 대기 안내 메시지
  private String confirmWaitingMessage;

  // 이메일 필수 여부
  private boolean emailPublic;

  // 전화번호 필수 여부
  private boolean phonePublic;

  // 공개용 전화번호
  private String phone;
}
