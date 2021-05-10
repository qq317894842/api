package com.service;

import com.entity.dto.AirPortLineData;
import com.entity.dto.BaggageLineData;
import com.entity.dto.CompanyLineData;
import com.entity.dto.TimeDto;

import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/20 14:26
 * @Description:
 */
public interface BigScreenService {

    List<BaggageLineData> countByCompany();

    List<CompanyLineData> countBySourceId();

    List<CompanyLineData> countByAireLineType();

    List<CompanyLineData> countByBaggageType();

    List<BaggageLineData> countTopFiveAirPort();

    List<AirPortLineData> countTopFiveBaggageType();

    List<BaggageLineData> countByPeak();

    List<BaggageLineData> countByIn(String time);

    List<BaggageLineData> countByOut(String time);
}
