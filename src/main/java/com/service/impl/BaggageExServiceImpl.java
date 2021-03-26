package com.service.impl;

import com.entity.dto.BaggageLineData;
import com.entity.dto.DrillParam;
import com.entity.dto.QueryParam;
import com.mapper.BaggageMapper;
import com.service.BaggageExService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/26 11:34
 * @Description:
 */
@Service
public class BaggageExServiceImpl implements BaggageExService {

    @Resource
    private BaggageMapper baggageMapper;


    @Override
    public List<BaggageLineData> countExByAirLine(QueryParam param) {
        return baggageMapper.countExByAirLine(param);
    }

    @Override
    public List<BaggageLineData> countExByTrace(QueryParam param) {
        return baggageMapper.countExByTrace(param);
    }

    @Override
    public List<BaggageLineData> countExByBaggage(QueryParam param) {
        return baggageMapper.countExByBaggage(param);
    }
}
