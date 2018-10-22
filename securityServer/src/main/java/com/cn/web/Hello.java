package com.cn.web;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")
public class Hello {
    @RequestMapping("/hi")
    public String hi() {
        return "Hi";
    }
}
