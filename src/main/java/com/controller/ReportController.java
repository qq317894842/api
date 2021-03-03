package com.controller;

import com.constant.ResultCode;
import com.entity.JimuReport;
import com.entity.ResultPojo;
import com.service.ReportService;
import com.utils.ReportUtils;
import com.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/2/24 11:15
 * @Description:
 */
@RequestMapping("/report")
@RestController
public class ReportController {

    @Resource
    private ReportService reportService;

    @RequestMapping("/getBarData")
    public String getJson(){
        String jsonStr = ReportUtils.getJsonStr();
        System.out.println(jsonStr);
        return jsonStr;
    }

    @CrossOrigin
    @RequestMapping("/getReportData")
    public ResultPojo getReportData(){
        List<JimuReport> jimuReports = reportService.getAllReport();
        return  ResultUtil.mix(ResultCode.SUCCESS, jimuReports);
    }

    @CrossOrigin
    @RequestMapping("/getReportById/{id}")
    public ResultPojo getReportById(@PathVariable("id") String id){
        JimuReport jimuReport = reportService.getReportById(id);
        return  ResultUtil.mix(ResultCode.SUCCESS, jimuReport);
    }
}

