package com.cn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableSe
@Log4j2
public class SecurityServerApplication {
    public static void main(String[] args) {
        log.debug("Security Server is running......");
        SpringApplication.run(SecurityServerApplication.class, args);
    }
}
