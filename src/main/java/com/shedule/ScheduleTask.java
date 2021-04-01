package com.shedule;

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
public class ScheduleTask {


    @Scheduled(cron="0/10 * * * * ? ")   //每10秒执行一次
    public void writeDBforReport(){
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format = LocalDateTime.now().format(f);
        System.out.println(format);
    }

}
