package com.cn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@Log4j2
public class WebApp_1 {
    public static void main(String[] args) {
        log.debug("Web App 1 is starting......");
        SpringApplication.run(WebApp_1.class, args);
    }
}