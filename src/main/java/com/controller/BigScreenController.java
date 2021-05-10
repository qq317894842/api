package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.constant.ResultCode;
import com.entity.ResultPojo;
import com.entity.dto.*;
import com.service.BigScreenService;
import com.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/20 14:25
 * @Description:
 */
@Api(tags = "大屏数据接口")
@RequestMapping("/bigScreen")
@RestController
public class BigScreenController {

    @Resource
    private BigScreenService bigScreenService;

    @ApiOperation("航司-按月统计行李量 9")
    @CrossOrigin
    @PostMapping("/countByCompany")
    public ResultPojo countByCompany(){
        List<BaggageLineData> dataList = bigScreenService.countByCompany();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }


    @ApiOperation("统计进港、离港行李量")
    @CrossOrigin
    @PostMapping("/countByOutIn")
    public ResultPojo countByOutIn(@RequestBody(required = false) TimeDto param){
        List<BaggageLineData> dataInList = bigScreenService.countByIn(param==null?null:param.getTime());
        List<BaggageLineData> dataOutList = bigScreenService.countByOut(param==null?null:param.getTime());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("in",dataInList);
        jsonObject.put("out",dataOutList);
//        jsonObject.put("transfer",dataTransferList);
        return  ResultUtil.mix(ResultCode.SUCCESS, jsonObject);
    }

    @ApiOperation("航司-行李来源统计(L离港,T中转,R/X 进港 9")
    @CrossOrigin
    @PostMapping("/countBySourceId")
    public ResultPojo countBySourceId(){
        List<CompanyLineData> dataList = bigScreenService.countBySourceId();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("航线来源统计(国际/国内) 9")
    @CrossOrigin
    @PostMapping("/countByAireLineType")
    public ResultPojo countByAireLineType(){
        List<CompanyLineData> dataList = bigScreenService.countByAireLineType();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("行李类型统计(超大行李，速运行李、特殊行李、要客行李、动物装笼、婴儿车、枪支等、空表示普通行李) 8")
    @CrossOrigin
    @PostMapping("/countByBaggageType")
    public ResultPojo countByBaggageType(){
        List<CompanyLineData> dataList = bigScreenService.countByBaggageType();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("高峰时段行李量统计 5")
    @CrossOrigin
    @PostMapping("/countByPeak")
    public ResultPojo countByPeak(){
        List<BaggageLineData> dataList = bigScreenService.countByPeak();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }


    @ApiOperation("统计前5机场的行李量 1")
    @CrossOrigin
    @PostMapping("/countTopFiveAirPort")
    public ResultPojo countTopFiveAirPort(){
        List<BaggageLineData> dataList = bigScreenService.countTopFiveAirPort();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("分类统计前5机场的行李量 2")
    @CrossOrigin
    @PostMapping("/countTopFiveBaggageType")
    public ResultPojo countTopFiveBaggageType(){
        List<AirPortLineData> dataList = bigScreenService.countTopFiveBaggageType();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }
}
