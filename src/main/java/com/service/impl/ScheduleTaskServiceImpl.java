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
import java.util.ArrayList;
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
            List<BaggageLineData> dataList = new ArrayList<>();
            //航司
//            dataList = mapper.countByAirLine(param);
//            addMapperRecord(dataList, DementionType.COMPANY.code());
//            //航站楼-离港
//            param.setType("1");
//            param.setTerminal(0);
//            dataList = mapper.countByAirLine(param);
//            addMapperRecord(dataList,DementionType.D_TERMINAL.code());
//            //航站楼-进港
//            param.setType("1");
//            param.setTerminal(1);
//            dataList = mapper.countByAirLine(param);
//            addMapperRecord(dataList,DementionType.A_TERMINAL.code());
            //操作员-行李
            param.setType("0");
            dataList = mapper.countByResource(param);
            addMapperRecord(dataList,DementionType.OPERATOR.code());
            //操作员-设备
            param.setType("1");
            dataList = mapper.countByResource(param);
            addMapperRecord(dataList,DementionType.RESOURCE.code());
            beginDate = beginDate.plusDays(1);

            //操作员-行李类型
            param.setType("0");
            dataList = mapper.countByBaggage(param);
            addMapperRecord(dataList,DementionType.BAGGAGETYPE.code());
            beginDate = beginDate.plusDays(1);
        }
    }

    private void addMapperRecord(List<BaggageLineData> dataList,Integer code) {
        for (int i = 0; i <dataList.size() ; i++) {
            BaggageLineData lineData = dataList.get(i);
            if(lineData==null){
                continue;
            }
            taskMapper.addRecord(lineData,code);
        }
    }

    @Override
    public void everyDayRun() {
        LocalDate  yesterday =  LocalDate.now().plusDays(-1);
        this.init(yesterday,yesterday);
    }
}
