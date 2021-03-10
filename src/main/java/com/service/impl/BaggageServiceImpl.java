package com.service.impl;

import com.entity.dto.BaggageLineData;
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
}
