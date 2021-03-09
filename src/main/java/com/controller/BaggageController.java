package com.controller;

import com.constant.ResultCode;
import com.entity.JimuReport;
import com.entity.ResultPojo;
import com.service.BaggageService;
import com.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/6 15:41
 * @Description:
 */
@Api(tags = "行李数据接口")
@RequestMapping("/bag")
@RestController
public class BaggageController {

    private BaggageService baggageService;

    @ApiOperation("")
    @CrossOrigin
    @RequestMapping("//{}")
    public ResultPojo getReportById(@PathVariable("id") String id){
//        JimuReport jimuReport = baggageService.getReportById(id);
        return  ResultUtil.mix(ResultCode.SUCCESS, null);
    }
}
