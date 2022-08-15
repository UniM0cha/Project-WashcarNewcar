package com.solstice.washcar_newcar.data.entity;

public enum Provider {
  Kakao("kakao"),
  Naver("naver"),
  Google("google");

  private final String name;

  Provider(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
