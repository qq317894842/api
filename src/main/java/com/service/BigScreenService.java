package com.service;

import com.entity.dto.*;

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

    List<BaggageLineData> countTopFiveAirPort(TimeDto time);

    List<AirPortLineData> countTopFiveBaggageType();

    List<BaggageLineData> countByPeak();

    List<BaggageLineData> countByIn(String time);

    List<BaggageLineData> countByOut(String time);

    List<BaggageLineData> countTopFiveCompany(TimeDto timeDto);

    List<AirPortLineData> countTopFiveCompanyBaggageType();

    List<BaggageLineData> countByCollect(String time);

    List<EffectDto> countByEff();

    List<BaggageLineData> countByErr();

    List<AirPortLineData> countTopFiveAirPortErr();
}
