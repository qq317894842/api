package com.controller;

import com.constant.ResultCode;
import com.entity.JimuReport;
import com.entity.ResultPojo;
import com.entity.dto.BaggageLineData;
import com.entity.dto.QueryParam;
import com.service.BaggageService;
import com.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/6 15:41
 * @Description:
 */
@Api(tags = "行李数据报表接口")
@RequestMapping("/bagReport")
@RestController
public class BaggageController {

    @Resource
    private BaggageService baggageService;

    @ApiOperation("航班视角")
    @CrossOrigin
    @PostMapping("/getDataByAirLine")
    public ResultPojo countByAirLine(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countByAirLine(param);
//        JimuReport jimuReport = baggageService.getReportById(id);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("跟踪点视角")
    @CrossOrigin
    @PostMapping("/getDataByAirLine")
    public ResultPojo countByAirLine2(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countByAirLine(param);
//        JimuReport jimuReport = baggageService.getReportById(id);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }
}
