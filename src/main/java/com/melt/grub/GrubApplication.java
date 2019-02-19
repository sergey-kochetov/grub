package com.melt.grub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableRetry
public class GrubApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrubApplication.class, args);
    }

    @Bean
    public WebMvcConfigurationSupport corsConfig() {
        return new WebMvcConfigurationSupport() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins("http://localhost:9000", "http://localhost:8080");
            }
        };
    }
}
