package com.service.impl;

import com.constant.TrancePoint;
import com.entity.dto.*;
import com.mapper.BigScreenMapper;
import com.service.BigScreenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/20 14:54
 * @Description:
 */
@Service
public class BigScreenServiceImpl implements BigScreenService {

    @Resource
    private BigScreenMapper mapper;


    @Override
    public List<BaggageLineData> countByCompany() {
        return mapper.countByCompany();
    }

    @Override
    public List<CompanyLineData> countBySourceId() {
        return mapper.countBySourceId();
    }

    @Override
    public List<CompanyLineData> countByAireLineType() {
        return mapper.countByAireLineType();
    }

    @Override
    public List<CompanyLineData> countByBaggageType() {
        return mapper.countByBaggageType();
    }

    @Override
    public List<BaggageLineData> countTopFiveAirPort(TimeDto timeDto) {
        List<String> airPortList = mapper.getTopFiveAirPort();
        return mapper.countTopFiveAirPort(airPortList,timeDto==null?null:timeDto.getTime());
    }

    @Override
    public List<AirPortLineData> countTopFiveBaggageType() {
        List<String> airPortList = mapper.getTopFiveAirPort();
        return mapper.countTopFiveBaggageType(airPortList);
    }

    @Override
    public List<BaggageLineData> countByPeak() {
        return mapper.countByPeak();
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
    public List<BaggageLineData> countTopFiveCompany(TimeDto timeDto) {
        List<String> fiveCompanyList = mapper.getTopFiveCompany();
        return mapper.countTopFiveCompany(fiveCompanyList,timeDto==null?null:timeDto.getTime());
    }

    @Override
    public List<AirPortLineData> countTopFiveCompanyBaggageType() {
        List<String> fiveCompanyList = mapper.getTopFiveCompany();
        return mapper.countTopFiveCompanyBaggageType(fiveCompanyList);
    }

    @Override
    public List<BaggageLineData> countByCollect(String time) {
        return mapper.countByCollect(time);
    }

    @Override
    public List<BaggageLineData> countByErr() {
        return mapper.countByErr();
    }

    @Override
    public List<AirPortLineData> countTopFiveAirPortErr() {
        List<String> airPortList = mapper.getTopFiveAirPort();
        return mapper.countTopFiveAirPortErr(airPortList);
    }

    @Override
    public List<EffectDto> countByEff() {
        EffectDto zhiji = mapper.countByEff(TrancePoint.ZHIJI, TrancePoint.ANJIAN);
        EffectDto anjian = mapper.countByEff(TrancePoint.ANJIAN,TrancePoint.FENJIAN);
        EffectDto fenjian =  mapper.countByEff(TrancePoint.FENJIAN,TrancePoint.ZHUANGCHE);
        EffectDto zhuangche = mapper.countByEff(TrancePoint.ZHUANGCHE,TrancePoint.ZHUANGJI);
        EffectDto zhuangji = mapper.countByEff(TrancePoint.ZHUANGJI,TrancePoint.XIECHE);
        EffectDto xieche = mapper.countByEff(TrancePoint.XIECHE,TrancePoint.TIQU);
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
