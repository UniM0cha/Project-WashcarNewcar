package com.solstice.washcar_newcar.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class CustomWebMvcConfig implements WebMvcConfigurer {

  @Value("${front_server}")
  private String frontServer;

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    log.info(frontServer);
    registry.addMapping("/**").allowedOrigins(frontServer);
  }
}
