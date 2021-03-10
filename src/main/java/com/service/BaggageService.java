package com.service;

import com.entity.dto.BaggageLineData;
import com.entity.dto.QueryParam;

import java.util.List;

public interface BaggageService {
    public List<BaggageLineData> countByAirLine(QueryParam type);
}
