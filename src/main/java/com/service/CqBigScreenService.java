package com.service;

import com.entity.dto.BaggageLineData;
import com.entity.dto.CqDrillParam;
import com.entity.dto.EffectDto;

import java.util.List;

public interface CqBigScreenService {

    List<BaggageLineData> countByCompany(CqDrillParam param);

    List<BaggageLineData> countByIn(String time);

    List<BaggageLineData> countByOut(String time);

    List<BaggageLineData> countByTransfer();

    List<BaggageLineData> countByPeak(String time);

    List<BaggageLineData> countByCollect(String time);

    List<EffectDto> countByEff();
}
