package com.cn.schedule;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Configuration
@EnableScheduling
@Log4j2
public class ScheduleTasks {

    private String currentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(new Date()).toString();
    }

    @Scheduled(fixedRate = 5 * 1000)
    public void reportCurrentByFixeRate() {
        log.debug("Current Time (per 5 seconds):" + currentTime());
    }

    @Scheduled(cron = "0 */1 *  * * * ")
    public void reportCurrentByCron() {
        log.debug("Current Time(per 1 minutes):" + currentTime());
    }
}
