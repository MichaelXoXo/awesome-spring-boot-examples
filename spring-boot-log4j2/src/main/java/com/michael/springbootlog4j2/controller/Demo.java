package com.michael.springbootlog4j2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael
 * @create 2019-08-06 22:32
 */
@RestController
public class Demo {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/debu")
    public String debug() {
        logger.debug("logger: debug");
        return "debug";
    }

    @GetMapping("/info")
    public String info() {
        logger.info("logger: info");
        return "info";
    }

    @GetMapping("/warn")
    public String warn() {
        logger.warn("logger: warn");
        return "warn";
    }

    @GetMapping("/error")
    public String error() {
        logger.error("logger: error");
        return "error";
    }

    @GetMapping("/all")
    public String all() {
        logger.debug("logger: debug");
        logger.info("logger: info");
        logger.warn("logger: warn");
        logger.error("logger: error");
        return "all";
    }
}
