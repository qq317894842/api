package com.controller;

import com.service.ReportService;
import com.utils.ReportUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: HuangRui
 * @Date: 2021/2/24 11:15
 * @Description:
 */
@RequestMapping("/report")
@RestController
public class ReportController {

    private ReportService reportService;

    @RequestMapping("/getBarData")
    public String getJson(){
        String jsonStr = ReportUtils.getJsonStr();
        System.out.println(jsonStr);
        return jsonStr;
    }

    @RequestMapping("/getReportData")
    public String getReportData(){
        String jsonStr = ReportUtils.getJsonStr();
        System.out.println(jsonStr);
        return jsonStr;
    }
}

