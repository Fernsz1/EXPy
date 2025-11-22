package com.appdev1.expy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class landingController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

       @GetMapping("/login")
    public String login() {
        return "login";
    }
}