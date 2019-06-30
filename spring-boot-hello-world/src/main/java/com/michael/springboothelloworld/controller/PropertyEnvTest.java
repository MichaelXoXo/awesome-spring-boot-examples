package com.michael.springboothelloworld.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael
 * @create 2019-06-30 23:35
 */
@RestController
public class PropertyEnvTest {
    @Value("${name.girl}")
    private String girlName;

    @GetMapping("/boy")
    public String getBoyName(){
        return System.getProperty("name.boy","翔");
    }

    @GetMapping("/girl")
    public String getGirlName(){
        return girlName;
    }
}
