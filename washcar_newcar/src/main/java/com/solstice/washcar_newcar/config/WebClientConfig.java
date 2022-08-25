package com.solstice.washcar_newcar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

  @Value("${whattime_api_key}")
  private String apiKey;

  @Bean
  public WebClient webClientWithToken(WebClient.Builder webClientBuilder) {
    return webClientBuilder
        .baseUrl("https://api.whattime.co.kr/v1/")
        .defaultHeader("Authorization", "Bearer " + apiKey)
        .build();
  }
}
