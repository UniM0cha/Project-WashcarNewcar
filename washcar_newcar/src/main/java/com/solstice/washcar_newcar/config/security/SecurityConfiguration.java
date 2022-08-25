package com.solstice.washcar_newcar.config.security;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.solstice.washcar_newcar.config.security.auth.CustomOAuth2UserService;
import com.solstice.washcar_newcar.config.security.auth.OAuth2AuthenticationSuccessHandler;
import com.solstice.washcar_newcar.config.security.jwt.JwtAccessDeniedHandler;
import com.solstice.washcar_newcar.config.security.jwt.JwtAuthenticationEntryPoint;
import com.solstice.washcar_newcar.config.security.jwt.JwtAuthenticationFilter;
import com.solstice.washcar_newcar.config.security.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final CustomOAuth2UserService customOAuth2UserService;
  private final OAuth2AuthenticationSuccessHandler oAuth2AuthenticationSuccessHandler;
  private final JwtTokenProvider jwtTokenProvider;
  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

  @Bean
  SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.csrf().disable(); // csrf 비활성화

    // 세션 비활성화
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http.formLogin().disable(); // formLogin 비활성화

    http.httpBasic().disable(); // 기존 인증 방식 비활성화

    // OAuth2의 절차가 끝난 후 데이터를 처리할 서비스를 지정해준다.
    // CustomOAuth2UserService는 OAuth2UserService를 상속받은 구현체.
    // userService를 지정해주지 않으면 DefaultOAuth2UserService가 실행된다.
    http.oauth2Login()
        .successHandler(oAuth2AuthenticationSuccessHandler)
        .userInfoEndpoint()
        .userService(customOAuth2UserService);

    // UsernamePasswordAuthenticationFilter 전에(앞에) JWT 필터 적용
    http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);

    // 예외처리 - 굳이해야하나..?
    // http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
    // .accessDeniedHandler(jwtAccessDeniedHandler);

    // 경로 보안 설정
    http.authorizeRequests(authorize -> authorize
        // .antMatchers("/api/v1/user/**")
        // .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or
        // hasRole('ROLE_ADMIN')")
        // .antMatchers("/api/v1/manager/**").access("hasRole('ROLE_MANAGER') or
        // hasRole('ROLE_ADMIN')")
        // .antMatchers("/api/v1/admin/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/provider/**").hasRole("PROVIDER")
        .anyRequest().permitAll());

    return http.build();
  }
}
