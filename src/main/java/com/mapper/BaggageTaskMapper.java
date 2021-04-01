package com.mapper;

import com.entity.dto.BaggageLineData;
import com.entity.dto.QueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/1 10:33
 * @Description:
 */
@Mapper
public interface BaggageTaskMapper {

    public int addRecord(BaggageLineData lineData,Integer dementionId,String dementionName);

}
