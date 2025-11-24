package com.appdev1.expy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // Cache static resources (images, CSS, JS) for 1 year
                registry.addResourceHandler("/images/**", "/css/**", "/js/**")
                        .addResourceLocations("classpath:/static/images/", 
                                             "classpath:/static/css/", 
                                             "classpath:/static/js/")
                        .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS)
                                .cachePublic()
                                .mustRevalidate());
            }
        };
    }
}
