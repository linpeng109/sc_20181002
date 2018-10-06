package com.cn.web;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@Log4j2
@RefreshScope
public class HelloController {
    @Value("${my.name}")
    public String myname;

    @GetMapping("/hi")
    public String hello() {
        String result = this.myname;
        log.debug("Hi Hello World! My name is " + result);
        return "Hi Hello World! My name is " + result;
    }
}
