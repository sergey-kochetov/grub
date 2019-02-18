package com.melt.grub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class GrubApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrubApplication.class, args);
    }
}
