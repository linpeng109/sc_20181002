package com.cn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@Log4j2
public class EurekaServer2Application {

    public static void main(String[] args) {
        log.debug("Eureka Server 2 is starting.....");
        SpringApplication.run(EurekaServer2Application.class, args);
    }
}
