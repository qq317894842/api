package com.service.impl;

import com.entity.dto.*;
import com.mapper.BaggageMapper;
import com.service.BaggageEffService;
import com.service.BaggageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/10 11:46
 * @Description:
 */
@Service
public class BaggageEffServiceImpl implements BaggageEffService {

    @Resource
    private BaggageMapper baggageMapper;

    @Override
    public List<BaggageLineData> countEffByAirLine(QueryParam param) {
        List<BaggageLineData> dataList = baggageMapper.countByAirLine(param);
        List<SumTimeDto> timeDtos = baggageMapper.sumTimeByAirLine(param);
        List<BaggageLineData> result = getEfficientResultData(dataList, timeDtos);

        return result;
    }

    @Override
    public List<BaggageLineData> countEffByTrace(QueryParam param) {
        List<BaggageLineData> dataList = baggageMapper.countByTrace(param);
        List<SumTimeDto> timeDtos = baggageMapper.sumTimeByTrace(param);
        List<BaggageLineData> result = getEfficientResultData(dataList, timeDtos);
        return result;
    }


    @Override
    public List<BaggageLineData> countEffByResource(QueryParam param) {
        List<BaggageLineData> dataList = baggageMapper.countByResource(param);
        List<SumTimeDto> timeDtos = baggageMapper.sumTimeByResource(param);
        List<BaggageLineData> result = getEfficientResultData(dataList, timeDtos);
        return result;
    }

    @Override
    public List<BaggageLineData> countEffByBaggage(QueryParam param) {
        List<BaggageLineData> dataList = baggageMapper.countByBaggage(param);
        List<SumTimeDto> timeDtos = baggageMapper.sumTimeByBaggage(param);
        List<BaggageLineData> result = getEfficientResultData(dataList, timeDtos);
        return result;
    }

    @Override
    public List<BaggageLineData> drillEffData(DrillParam param) {
        return baggageMapper.drillData(param);
    }


    private List<BaggageLineData> getEfficientResultData(List<BaggageLineData> dataList, List<SumTimeDto> timeDtos) {
        List<BaggageLineData> result = new ArrayList<>();
        for (BaggageLineData data : dataList) {
            for (SumTimeDto sumTimeDto : timeDtos) {
                if (sumTimeDto!=null&&data!=null&&sumTimeDto.getType() != null && data.getType() != null) {
                    if (sumTimeDto.getType().equals(data.getType())) {
                        double efficient = sumTimeDto.getSum() / data.getCount();
                        data.setCount(efficient);
                        result.add(data);
                    }
                }
            }
        }
        return result;
    }


}
