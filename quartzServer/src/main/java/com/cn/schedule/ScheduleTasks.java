package com.cn.schedule;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Configuration
@EnableScheduling
@Log4j2
public class ScheduleTasks {

    private RestTemplate restTemplate = new RestTemplate();

    private String getObjectByRestTemplate() {
        return restTemplate.getForObject("http://localhost:8080/v1/webapp/userbase/findAll/1/5", String.class);
    }

    private String currentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(new Date()).toString();
    }

    @Scheduled(fixedRate = 5 * 1000)
    public void reportCurrentByFixeRate() {
        log.debug("Fixed Rate mode. Per five seconds. Current Time is " + currentTime());
    }

    @Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron() {
        log.debug("Cron mode. Per minutes.Get Object By RestTemplate : " + this.getObjectByRestTemplate());
    }
}
