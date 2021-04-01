package com.service.impl;

import com.constant.DementionType;
import com.entity.dto.BaggageLineData;
import com.entity.dto.QueryParam;
import com.mapper.BaggageMapper;
import com.mapper.BaggageTaskMapper;
import com.service.ScheduleTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/31 11:29
 * @Description:
 */
@Service(value = "scheduleTaskService")
public class ScheduleTaskServiceImpl implements ScheduleTaskService {

    @Resource
    private BaggageMapper mapper;

    @Resource
    private BaggageTaskMapper taskMapper;

    @Override
    public void init(LocalDate beginDate, LocalDate endDate) {
        LocalTime beginTime = LocalTime.of(0, 0,0);
        LocalTime endTime = LocalTime.of(23, 59,59);
        while(!beginDate.isAfter(endDate)){
            LocalDateTime beginDateTime = LocalDateTime.of(beginDate,beginTime);
            LocalDateTime endDateTime = LocalDateTime.of(beginDate,endTime);

            QueryParam param = QueryParam.builder().beginTime(beginDateTime).endTime(endDateTime)
                    .type("0").granularity(0).build();
            List<BaggageLineData> dataList = mapper.countByAirLine(param);
            for (int i = 0; i <dataList.size() ; i++) {
                BaggageLineData lineData = dataList.get(i);
                if(lineData==null){
                    continue;
                }
                int id = taskMapper.addRecord(lineData, DementionType.COMPANY.code(),DementionType.COMPANY.value());
                System.out.println("add success id:"+id);
            }
            beginDate = beginDate.plusDays(1);
        }
    }

    @Override
    public void everyDayRun() {

    }
}
