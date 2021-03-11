package com.controller;

import com.constant.ResultCode;
import com.entity.JimuReport;
import com.entity.ResultPojo;
import com.entity.dto.BaggageLineData;
import com.entity.dto.DrillParam;
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
@RequestMapping("/api/bagReport")
@RestController
public class BaggageController {

    @Resource
    private BaggageService baggageService;

    @ApiOperation("航班视角")
    @CrossOrigin
    @PostMapping("/getDataByAirLine")
    public ResultPojo countByAirLine(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countByAirLine(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("跟踪点视角")
    @CrossOrigin
    @PostMapping("/getDataByTrace")
    public ResultPojo getDataByTrace(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countByTrace(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("资源视角")
    @CrossOrigin
    @PostMapping("/getDataByResource")
    public ResultPojo getDataByResource(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countByResource(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("行李视角")
    @CrossOrigin
    @PostMapping("/getDataByBaggage")
    public ResultPojo getDataByBaggage(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countByBaggage(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("数据钻取")
    @CrossOrigin
    @PostMapping("/drillData")
    public ResultPojo drillData(@RequestBody DrillParam param){
        List<BaggageLineData> dataList = baggageService.drillData(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }
}
