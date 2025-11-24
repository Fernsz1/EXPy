package com.appdev1.expy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "index"; // index.html
    }

    @GetMapping("/students")
    public String students() {
        return "students"; // students.html
    }

    
        @GetMapping("/login")
     public String login() {
         return "login";
     }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/home")
    public String dashboard() {
        return "home";
    }

    @GetMapping("/lessons")
    public String lessons() {
        return "lessons";
    }

    @GetMapping("/challenges")
    public String challenges() {
        return "challenges";
    }

    @GetMapping("/playground")
    public String playground() {
        return "playground";
    }
}
