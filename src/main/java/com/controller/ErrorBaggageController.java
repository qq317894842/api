package com.controller;

import com.constant.ResultCode;
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
 * @Date: 2021/3/17 14:39
 * @Description:
 */
@Api(tags = "异常行李数据报表接口")
@RequestMapping("/errorBaggage")
@RestController
public class ErrorBaggageController {
    @Resource
    private BaggageService baggageService;

    @ApiOperation("航班视角")
    @CrossOrigin
    @PostMapping("/getDataByAirLine")
    public ResultPojo countByAirLine(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countErrByAirLine(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("跟踪点视角")
    @CrossOrigin
    @PostMapping("/getDataByTrace")
    public ResultPojo getDataByTrace(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countErrByTrace(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("资源视角")
    @CrossOrigin
    @PostMapping("/getDataByResource")
    public ResultPojo getDataByResource(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countErrByResource(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("行李视角")
    @CrossOrigin
    @PostMapping("/getDataByBaggage")
    public ResultPojo getDataByBaggage(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageService.countErrByBaggage(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("数据钻取")
    @CrossOrigin
    @PostMapping("/drillData")
    public ResultPojo drillData(@RequestBody DrillParam param){
        List<BaggageLineData> dataList = baggageService.drillErrData(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }
}
