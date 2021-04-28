package com.service.impl;

import com.constant.CqTrancePoint;
import com.entity.dto.BaggageLineData;
import com.entity.dto.CqDrillParam;
import com.entity.dto.EffectDto;
import com.mapper.CqBigScreenMapper;
import com.service.CqBigScreenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/23 11:04
 * @Description:
 */
@Service
public class CqBigScreenServiceImpl implements CqBigScreenService {

    @Resource
    private CqBigScreenMapper mapper;

    @Override
    public List<BaggageLineData> countByCompany(CqDrillParam param) {
        return mapper.countByCompany(param);
    }

    @Override
    public List<BaggageLineData> countByIn(String time) {
        return mapper.countByIn(time);
    }

    @Override
    public List<BaggageLineData> countByOut(String time) {
        return mapper.countByOut(time);
    }

    @Override
    public List<BaggageLineData> countByTransfer() {
        return mapper.countByTransfer();
    }

    @Override
    public List<BaggageLineData> countByPeak(String time) {
        return mapper.countByPeak(time);
    }

    @Override
    public List<BaggageLineData> countByCollect(String time) {
        return mapper.countByCollect(time);
    }

    @Override
    public List<EffectDto> countByEff() {
        EffectDto zhiji = mapper.countByEff(CqTrancePoint.ZHIJI, CqTrancePoint.ANJIAN);
        EffectDto anjian = mapper.countByEff(CqTrancePoint.ANJIAN,CqTrancePoint.FENJIAN);
        EffectDto fenjian =  mapper.countByEff(CqTrancePoint.FENJIAN,CqTrancePoint.ZHUANGCHE);
        EffectDto zhuangche = mapper.countByEff(CqTrancePoint.ZHUANGCHE,CqTrancePoint.ZHUANGJI);
        EffectDto zhuangji = mapper.countByEff(CqTrancePoint.ZHUANGJI,CqTrancePoint.XIECHE);
        EffectDto xieche = mapper.countByEff(CqTrancePoint.XIECHE,CqTrancePoint.TIQU);
        List<EffectDto> effectDtos = new ArrayList<>();
        effectDtos.add(zhiji);
        effectDtos.add(anjian);
        effectDtos.add(fenjian);
        effectDtos.add(zhuangche);
        effectDtos.add(zhuangji);
        effectDtos.add(xieche);
        return effectDtos;
    }
}
