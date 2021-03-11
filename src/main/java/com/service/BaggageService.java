package com.service;

import com.entity.dto.BaggageLineData;
import com.entity.dto.DrillParam;
import com.entity.dto.QueryParam;

import java.util.List;

public interface BaggageService {
    public List<BaggageLineData> countByAirLine(QueryParam param);

    public List<BaggageLineData> countByTrace(QueryParam param);

    List<BaggageLineData> countByResource(QueryParam param);

    List<BaggageLineData> countByBaggage(QueryParam param);

    List<BaggageLineData> drillData(DrillParam param);
}
