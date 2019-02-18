package com.melt.grub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HealthController {

    private Random random = new Random();

    @RequestMapping("/health")
    public ResponseEntity<String> getStatus() {
        int randomInt = random.nextInt(2);
        if (randomInt == 1) {
            return new ResponseEntity<>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
