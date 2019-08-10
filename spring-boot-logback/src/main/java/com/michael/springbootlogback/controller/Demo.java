package com.michael.springbootlogback.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Michael
 * @create 2019-08-09 20:53
 */
@Slf4j
@RestController
public class Demo {
//    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/debu")
    public String debug() {
        log.debug("log: debug");
        return "debug";
    }

    @GetMapping("/info")
    public String info() {
        log.info("log: info");
        return "info";
    }

    @GetMapping("/warn")
    public String warn() {
        log.warn("log: warn");
        return "warn";
    }

    @GetMapping("/error")
    public String error() {
        log.error("log: error");
        return "error";
    }

    @GetMapping("/all")
    public String all() {
        try {
            log.debug("log: debug");
            log.info("log: info");
            log.warn("log: warn" + " 附件个信息");
            System.out.println(1 / 0);
        } catch (Exception e) {
            log.error("error 打印方式比较，采用 ,e：", e);
            log.error("error 打印方式比较，采用 +e : " + e);
            log.error("error 打印方式比较，采用 e 括号 :{} " , e);
            throw e;
        }
        return "all";
    }
}
