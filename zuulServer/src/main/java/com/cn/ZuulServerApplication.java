package com.cn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@Log4j2
public class ZuulServerApplication {
    public static void main(String[] args) {
        log.debug("Zuul Server is starting......");
        SpringApplication.run(ZuulServerApplication.class, args);
    }
}
