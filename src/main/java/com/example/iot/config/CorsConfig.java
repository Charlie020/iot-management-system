package com.example.iot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOriginPatterns("/*")
//                .allowedMethods("GET", "POST", "DELETE", "PUT")
//                .maxAge(168000)
//                .allowedHeaders("*")
//                .allowCredentials(true);
    }
}
