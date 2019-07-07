package com.michael.springboothelloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael
 * @create 2019-06-30 23:33
 */
@RestController
public class HelloWorld {
    @Value(value = "${author.name}")
    private String authorName;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World By " + authorName;
    }

}