package com.controller;

import com.constant.ResultCode;
import com.entity.ResultPojo;
import com.entity.dto.AirPortLineData;
import com.entity.dto.BaggageLineData;
import com.entity.dto.TimeDto;
import com.service.BigScreenService;
import com.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/5/17 17:52
 * @Description:
 */
@Api(tags = "大屏数据接口(航司)")
@RequestMapping("/bigScreen2")
@RestController
public class BigScreenController2 {

    @Resource
    private BigScreenService bigScreenService;

    @ApiOperation("统计前5(航司)的行李量 1")
    @CrossOrigin
    @PostMapping("/countTopFiveAirPort")
    public ResultPojo countTopFiveAirPort(@RequestBody(required = false) TimeDto timeDto){
        List<BaggageLineData> dataList = bigScreenService.countTopFiveCompany(timeDto);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("分类统计前5(航司)的行李量 2")
    @CrossOrigin
    @PostMapping("/countTopFiveBaggageType")
    public ResultPojo countTopFiveBaggageType(){
        List<AirPortLineData> dataList = bigScreenService.countTopFiveCompanyBaggageType();
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }
}
