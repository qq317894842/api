package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.constant.CqTrancePoint;
import com.constant.ResultCode;
import com.entity.ResultPojo;
import com.entity.dto.BaggageLineData;
import com.entity.dto.CqDrillParam;
import com.entity.dto.EffectDto;
import com.entity.dto.TimeDto;
import com.service.CqBigScreenService;
import com.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/23 10:56
 * @Description:
 */
@Api(tags = "重庆机场_大屏数据接口")
@RequestMapping("/cqbigScreen")
@RestController
public class CqController {

    @Resource
    private CqBigScreenService cqbigScreenService;


    @ApiOperation("按航司统计行李量")
    @CrossOrigin
    @PostMapping("/countByCompany")
    public ResultPojo countByCompany(@RequestBody(required = false) CqDrillParam param){
        List<BaggageLineData> dataList = cqbigScreenService.countByCompany(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }


    @ApiOperation("航司行李分类")
    @CrossOrigin
    @PostMapping("/countByCompanyAndType")
    public ResultPojo countByCompanyAndType(@RequestBody(required = false) CqDrillParam param){
        List<BaggageLineData> dataList = cqbigScreenService.countByCompany(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("机场行李分类")
    @CrossOrigin
    @PostMapping("/countByAirPortAndType")
    public ResultPojo countByAirPortAndType(@RequestBody(required = false) TimeDto param){
        List<BaggageLineData> dataInList = cqbigScreenService.countByIn(param==null?null:param.getTime());
        List<BaggageLineData> dataOutList = cqbigScreenService.countByOut(param==null?null:param.getTime());
//        List<BaggageLineData> dataTransferList = cqbigScreenService.countByTransfer();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("out",dataOutList);
        jsonObject.put("in",dataInList);
        return  ResultUtil.mix(ResultCode.SUCCESS, jsonObject);
    }


    @ApiOperation("统计进港、离港行李量")
    @CrossOrigin
    @PostMapping("/countByOutIn")
    public ResultPojo countByOutIn(@RequestBody(required = false) TimeDto param){
        List<BaggageLineData> dataInList = cqbigScreenService.countByIn(param==null?null:param.getTime());
        List<BaggageLineData> dataOutList = cqbigScreenService.countByOut(param==null?null:param.getTime());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("in",dataInList);
        jsonObject.put("out",dataOutList);
//        jsonObject.put("transfer",dataTransferList);
        return  ResultUtil.mix(ResultCode.SUCCESS, jsonObject);
    }

    @ApiOperation("统计值机业务高峰时间点 ")
    @CrossOrigin
    @PostMapping("/countByPeak")
    public ResultPojo countByPeak(@RequestBody(required = false)  TimeDto param){
        List<BaggageLineData> dataList = cqbigScreenService.countByPeak(param==null?null:param.getTime());
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("统计每个年度行李数据量")
    @CrossOrigin
    @PostMapping("/countByCollect")
    public ResultPojo  countByCollect(@RequestBody(required = false) TimeDto param){
        List<BaggageLineData> dataList = cqbigScreenService.countByCollect(param==null?null:param.getTime());
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("统计节点效率")
    @CrossOrigin
    @PostMapping("/countByEff")
    public ResultPojo  countByEff(){
        List<EffectDto> dataList = cqbigScreenService.countByEff();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("异常统计")
    @CrossOrigin
    @PostMapping("/countByErr")
    public ResultPojo  countByErr(){
        List<BaggageLineData> dataList =new ArrayList<>();
        BaggageLineData ds = BaggageLineData.builder().count(1.0).time("2021").type("丢失").build();
        BaggageLineData ps = BaggageLineData.builder().count(15.0).time("2021").type("破损").build();
        BaggageLineData yw = BaggageLineData.builder().count(48.0).time("2021").type("延误").build();
        BaggageLineData cy = BaggageLineData.builder().count(11.0).time("2021").type("错运").build();

        dataList.add(ds);
        dataList.add(ps);
        dataList.add(yw);
        dataList.add(cy);

        BaggageLineData ds2 = BaggageLineData.builder().count(2.0).time("2020").type("丢失").build();
        BaggageLineData ps2 = BaggageLineData.builder().count(18.0).time("2020").type("破损").build();
        BaggageLineData yw2 = BaggageLineData.builder().count(57.0).time("2020").type("延误").build();
        BaggageLineData cy2 = BaggageLineData.builder().count(12.0).time("2020").type("错运").build();

        dataList.add(ds2);
        dataList.add(ps2);
        dataList.add(yw2);
        dataList.add(cy2);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }



}
