package com.mapper;

import com.entity.dto.BaggageLineData;
import com.entity.dto.QueryParam;

import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/10 11:28
 * @Description:
 */
public interface BaggageMapper {

    /**
     *
     * @param type  type.granularity  1：年   2：月  3：周   4：小时  0: 日
     * @return
     */
    public List<BaggageLineData> countByAirLine(QueryParam type);

}
