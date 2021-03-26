package com.controller;

import com.constant.ResultCode;
import com.entity.ResultPojo;
import com.entity.dto.BaggageLineData;
import com.entity.dto.DrillParam;
import com.entity.dto.QueryParam;
import com.service.BaggageExService;
import com.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/26 10:41
 * @Description:
 */
@Api(tags = "数据交换统计报表接口")
@RequestMapping("/exchange")
@RestController
public class ExchangeController {

    @Resource
    private BaggageExService baggageExService;

    @ApiOperation("航班视角")
    @CrossOrigin
    @PostMapping("/getDataByAirLine")
    public ResultPojo countByAirLine(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageExService.countExByAirLine(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

    @ApiOperation("跟踪点视角")
    @CrossOrigin
    @PostMapping("/getDataByTrace")
    public ResultPojo getDataByTrace(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageExService.countExByTrace(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

//    @ApiOperation("资源视角")
//    @CrossOrigin
//    @PostMapping("/getDataByResource")
//    public ResultPojo getDataByResource(@RequestBody QueryParam param){
//
//        List<BaggageLineData> dataList = baggageExService.countByResource(param);
//        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
//    }

    @ApiOperation("行李视角")
    @CrossOrigin
    @PostMapping("/getDataByBaggage")
    public ResultPojo getDataByBaggage(@RequestBody QueryParam param){

        List<BaggageLineData> dataList = baggageExService.countExByBaggage(param);
        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
    }

//    @ApiOperation("数据钻取")
//    @CrossOrigin
//    @PostMapping("/drillData")
//    public ResultPojo drillData(@RequestBody DrillParam param){
//        List<BaggageLineData> dataList = baggageExService.drillData(param);
//        return  ResultUtil.mix(ResultCode.SUCCESS, dataList);
//    }
}
