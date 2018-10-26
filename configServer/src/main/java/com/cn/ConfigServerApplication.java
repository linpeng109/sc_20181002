package com.cn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
@Log4j2
public class ConfigServerApplication {
    public static void main(String[] args) {
        log.debug("Config Server is starting......");
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
