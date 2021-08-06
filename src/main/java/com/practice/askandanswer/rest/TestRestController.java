package com.practice.askandanswer.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestController {
    @GetMapping("/")
    public String sayHello(){
        return "hello";
    }
}
