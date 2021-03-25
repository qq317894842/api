package com.service;

import com.entity.dto.*;

import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/24 10:42
 * @Description:
 */
public interface BaggageEffService {
    List<BaggageLineData> countEffByAirLine(QueryParam param);

    List<BaggageLineData> countEffByTrace(QueryParam param);

    List<BaggageLineData> countEffByResource(QueryParam param);

    List<BaggageLineData> countEffByBaggage(QueryParam param);

    List<BaggageLineData> drillEffData(DrillParam param);
}
