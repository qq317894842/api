package com.mapper;

import com.entity.dto.AirPortLineData;
import com.entity.dto.BaggageLineData;
import com.entity.dto.CompanyLineData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BigScreenMapper {

    List<BaggageLineData> countByCompany();

    List<CompanyLineData> countBySourceId();

    List<CompanyLineData> countByAireLineType();

    List<CompanyLineData> countByBaggageType();

    List<String> getTopFiveAirPort();

    List<BaggageLineData> countTopFiveAirPort(@Param(value = "list") List<String> airPortList);

    List<AirPortLineData> countTopFiveBaggageType(@Param(value = "list") List<String> airPortList);

    List<BaggageLineData> countByPeak();

}
