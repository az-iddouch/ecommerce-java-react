package com.vash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/api/ping")
    public String ping(){
        return "pong";
    }
}
