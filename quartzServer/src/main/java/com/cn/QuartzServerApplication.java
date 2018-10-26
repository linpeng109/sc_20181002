package com.cn;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class QuartzServerApplication {
    public static void main(String[] args) {
        log.debug("Quartz Server is starting......");
        SpringApplication.run(QuartzServerApplication.class, args);
    }
}
