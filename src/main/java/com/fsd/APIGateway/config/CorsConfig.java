package com.fsd.APIGateway.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

  @Bean
  public CorsWebFilter corsWebFilter() {
      CorsConfiguration corsConfig = new CorsConfiguration();
      corsConfig.addAllowedOrigin("http://localhost:3000"); // Allow all origins
      corsConfig.addAllowedMethod("*"); // Allow all methods (GET, POST, etc.)
      corsConfig.addAllowedHeader("*"); // Allow all headers
      corsConfig.setAllowCredentials(true);

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/query/**", corsConfig);

      return new CorsWebFilter(source);
  }
}


