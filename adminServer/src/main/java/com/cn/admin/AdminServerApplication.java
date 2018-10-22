package com.cn.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableAdminServer
@SpringBootApplication
@Log4j2
public class AdminServerApplication {
    public static void main(String[] args) {
        log.debug("AdminServerApplication start running......");
        SpringApplication.run(AdminServerApplication.class, args);
    }
}
