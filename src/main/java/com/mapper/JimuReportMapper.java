package com.mapper;

import com.entity.JimuReport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JimuReportMapper {
    public List<JimuReport> selectAll();
}
