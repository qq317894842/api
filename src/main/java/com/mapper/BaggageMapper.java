package com.mapper;

import com.entity.dto.BaggageLineData;
import com.entity.dto.DrillParam;
import com.entity.dto.QueryParam;
import com.entity.dto.SumTimeDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/10 11:28
 * @Description:
 */
@Mapper
@Component(value = "baggageMapper")
public interface BaggageMapper {

    /**
     *
     * @param type  type.granularity  1：年   2：月  3：周   4：小时  0: 日
     * @return
     */
    public List<BaggageLineData> countByAirLine(QueryParam type);

    public List<BaggageLineData> countByTrace(QueryParam type);

    List<BaggageLineData> countByResource(QueryParam param);

    List<BaggageLineData> countByBaggage(QueryParam param);

    List<BaggageLineData> drillData(DrillParam param);

    List<BaggageLineData> countErrByAirLine(QueryParam param);

    List<BaggageLineData> countErrByTrace(QueryParam param);

    List<BaggageLineData> countErrByResource(QueryParam param);

    List<BaggageLineData> countErrByBaggage(QueryParam param);

    List<BaggageLineData> drillErrData(DrillParam param);

    List<BaggageLineData> countExByAirLine(QueryParam param);

    List<BaggageLineData> countExByTrace(QueryParam param);

    List<BaggageLineData> countExByBaggage(QueryParam param);

    List<BaggageLineData> countExBySource(QueryParam param);
//
//    List<BaggageLineData> countEffByBaggage(QueryParam param);

    List<BaggageLineData> drillEffData(DrillParam param);

//    List<BaggageLineData> countEffByAirLine(QueryParam param);


    List<SumTimeDto> sumTimeByAirLine(QueryParam param);

    List<SumTimeDto> sumTimeByTrace(QueryParam param);

    List<SumTimeDto> sumTimeByResource(QueryParam param);

    List<SumTimeDto> sumTimeByBaggage(QueryParam param);
}
