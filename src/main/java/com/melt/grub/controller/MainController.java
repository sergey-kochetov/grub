package com.melt.grub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String hello() {
        return "login";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
