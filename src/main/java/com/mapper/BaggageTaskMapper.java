package com.mapper;

import com.entity.dto.BaggageLineData;
import com.entity.dto.QueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/1 10:33
 * @Description:
 */
@Mapper
public interface BaggageTaskMapper {

    int addRecord(@Param(value = "data") BaggageLineData lineData,@Param(value = "dementionId")  Integer dementionId);

    void createNewTable(@Param(value = "tableName")String tableName,@Param(value = "comment")String comment);

}
