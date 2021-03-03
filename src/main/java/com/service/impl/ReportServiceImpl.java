package com.service.impl;

import com.entity.JimuReport;
import com.mapper.JimuReportMapper;
import com.service.ReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/2/25 15:16
 * @Description:
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    private JimuReportMapper jimuReportMapper;

    @Override
    public List<JimuReport> getAllReport() {
        return jimuReportMapper.selectAll();
    }

    @Override
    public JimuReport getReportById(String id) {
        return jimuReportMapper.getReportById(id);
    }
}
