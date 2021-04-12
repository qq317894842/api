package com.shedule;

import com.service.ScheduleTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/31 10:19
 * @Description:
 */
@EnableScheduling
@Component
@Slf4j
public class ScheduleTask {

    @Autowired
    private ScheduleTaskService scheduleTaskService;

    @Scheduled(cron="* * 2 * * ? ")   //每天两点
    public void writeDBforReport(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = LocalDateTime.now().format(f);
        scheduleTaskService.everyDayRun();
        log.info("scheduleTask:" + format);
    }

}
