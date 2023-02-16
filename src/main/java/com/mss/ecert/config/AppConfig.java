package com.mss.ecert.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.mss.ecert.domain.User;



@Configuration
public class AppConfig {
  @Bean
  public User user() {
    return new User();
  }
}