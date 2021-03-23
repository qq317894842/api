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



    List<BaggageLineData> countErrByAirLine(QueryParam param);

    List<BaggageLineData> countErrByTrace(QueryParam param);

    List<BaggageLineData> countErrByResource(QueryParam param);

    List<BaggageLineData> countErrByBaggage(QueryParam param);

    List<BaggageLineData> drillErrData(DrillParam param);



    List<BaggageLineData> countEffByAirLine(QueryParam param);

    List<BaggageLineData> countEffByTrace(QueryParam param);

    List<BaggageLineData> countEffByResource(QueryParam param);

    List<BaggageLineData> countEffByBaggage(QueryParam param);

    List<BaggageLineData> drillEffData(DrillParam param);

}
