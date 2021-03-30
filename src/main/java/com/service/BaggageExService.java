package com.service;

import com.entity.dto.BaggageLineData;
import com.entity.dto.DrillParam;
import com.entity.dto.QueryParam;

import java.util.List;

public interface BaggageExService {

    List<BaggageLineData> countExByAirLine(QueryParam param);

    List<BaggageLineData> countExByTrace(QueryParam param);

//    List<BaggageLineData> countExByResource(QueryParam param);
//
    List<BaggageLineData> countExByBaggage(QueryParam param);

    List<BaggageLineData> countExBySource(QueryParam param);
//
//    List<BaggageLineData> drillExData(DrillParam param);
}
