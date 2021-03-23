package com.service.impl;

import com.entity.dto.BaggageLineData;
import com.entity.dto.DrillParam;
import com.entity.dto.QueryParam;
import com.mapper.BaggageMapper;
import com.service.BaggageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/10 11:46
 * @Description:
 */
@Service
public class BaggageServiceImpl implements BaggageService {

    @Resource
    private BaggageMapper baggageMapper;

    @Override
    public List<BaggageLineData> countByAirLine(QueryParam param) {
        return baggageMapper.countByAirLine(param);
    }

    @Override
    public List<BaggageLineData> countByTrace(QueryParam param) {
        return baggageMapper.countByTrace(param);
    }

    @Override
    public List<BaggageLineData> countByResource(QueryParam param) {
        return baggageMapper.countByResource(param);
    }

    @Override
    public List<BaggageLineData> countByBaggage(QueryParam param) {
        return baggageMapper.countByBaggage(param);
    }

    @Override
    public List<BaggageLineData> drillData(DrillParam param) {
        return baggageMapper.drillData(param);
    }

    @Override
    public List<BaggageLineData> countErrByAirLine(QueryParam param) {
        return baggageMapper.countErrByAirLine(param);
    }

    @Override
    public List<BaggageLineData> countErrByTrace(QueryParam param) {
        return baggageMapper.countErrByTrace(param);
    }

    @Override
    public List<BaggageLineData> countErrByResource(QueryParam param) {
        return baggageMapper.countErrByResource(param);
    }

    @Override
    public List<BaggageLineData> countErrByBaggage(QueryParam param) {
        return baggageMapper.countErrByBaggage(param);
    }

    @Override
    public List<BaggageLineData> drillErrData(DrillParam param) {
        return baggageMapper.drillErrData(param);
    }

    @Override
    public List<BaggageLineData> countEffByAirLine(QueryParam param) {
        return baggageMapper.countEffByAirLine(param);
    }

    @Override
    public List<BaggageLineData> countEffByTrace(QueryParam param) {
        return baggageMapper.countEffByTrace(param);
    }

    @Override
    public List<BaggageLineData> countEffByResource(QueryParam param) {
        return baggageMapper.countEffByResource(param);
    }

    @Override
    public List<BaggageLineData> countEffByBaggage(QueryParam param) {
        return baggageMapper.countEffByBaggage(param);
    }

    @Override
    public List<BaggageLineData> drillEffData(DrillParam param) {
        return baggageMapper.drillEffData(param);
    }
}
