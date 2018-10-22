package com.cn.eureka;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@Log4j2
public class EurekaServer1Application {

    public static void main(String[] args) {
        log.debug("EurekaServer1Application start running.....");
        SpringApplication.run(EurekaServer1Application.class, args);
    }
}
