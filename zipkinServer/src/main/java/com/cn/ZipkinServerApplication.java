package com.cn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
@Log4j2
public class ZipkinServerApplication {
    public static void main(String[] args) {
        log.debug("Zipkin Server is starting......");
        SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
