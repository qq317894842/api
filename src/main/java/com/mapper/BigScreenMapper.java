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

    List<BaggageLineData> countTopFiveAirPort(@Param(value = "list") List<String> airPortList,@Param(value = "time")String time);

    List<AirPortLineData> countTopFiveBaggageType(@Param(value = "list") List<String> airPortList);

    List<BaggageLineData> countByPeak();

    List<BaggageLineData> countByIn(String time);

    List<BaggageLineData> countByOut(String time);

    List<String> getTopFiveCompany();

    List<BaggageLineData> countTopFiveCompany(@Param(value = "list")List<String> fiveCompanyList,@Param(value = "time")String time);

    List<AirPortLineData> countTopFiveCompanyBaggageType(@Param(value = "list") List<String> fiveCompanyList);
}
