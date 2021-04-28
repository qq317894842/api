package com.mapper;

import com.entity.dto.BaggageLineData;
import com.entity.dto.CqDrillParam;
import com.entity.dto.EffectDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CqBigScreenMapper {

    List<BaggageLineData> countByCompany(CqDrillParam param);

    List<BaggageLineData> countByIn(@Param(value = "time") String time);

    List<BaggageLineData> countByOut(@Param(value = "time") String time);

    List<BaggageLineData> countByTransfer();

    List<BaggageLineData> countByPeak(@Param(value = "time") String time);

    List<BaggageLineData> countByCollect(@Param(value = "time") String time);

    EffectDto countByEff(@Param(value = "point")String point, @Param(value = "nextPoint") String nextPoint);
}
