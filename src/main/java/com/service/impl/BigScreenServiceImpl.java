package com.service.impl;

import com.entity.dto.AirPortLineData;
import com.entity.dto.BaggageLineData;
import com.entity.dto.CompanyLineData;
import com.mapper.BigScreenMapper;
import com.service.BigScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/20 14:54
 * @Description:
 */
@Service
public class BigScreenServiceImpl implements BigScreenService {

    @Resource
    private BigScreenMapper mapper;


    @Override
    public List<BaggageLineData> countByCompany() {
        return mapper.countByCompany();
    }

    @Override
    public List<CompanyLineData> countBySourceId() {
        return mapper.countBySourceId();
    }

    @Override
    public List<CompanyLineData> countByAireLineType() {
        return mapper.countByAireLineType();
    }

    @Override
    public List<CompanyLineData> countByBaggageType() {
        return mapper.countByBaggageType();
    }

    @Override
    public List<BaggageLineData> countTopFiveAirPort() {
        List<String> airPortList = mapper.getTopFiveAirPort();
        return mapper.countTopFiveAirPort(airPortList);
    }

    @Override
    public List<AirPortLineData> countTopFiveBaggageType() {
        List<String> airPortList = mapper.getTopFiveAirPort();
        return mapper.countTopFiveBaggageType(airPortList);
    }

    @Override
    public List<BaggageLineData> countByPeak() {
        return mapper.countByPeak();
    }

    @Override
    public List<BaggageLineData> countByIn(String time) {
        return mapper.countByIn(time);
    }

    @Override
    public List<BaggageLineData> countByOut(String time) {
        return mapper.countByOut(time);
    }
}
