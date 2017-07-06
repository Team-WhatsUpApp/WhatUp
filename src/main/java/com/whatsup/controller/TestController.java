package com.whatsup.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DelMonroe on 7/2/17.
 */
@RestController
public class TestController {

    @RequestMapping("/testpage")
    public String home() {
        return "Hello! ... I am working!!!!";
    }

}
