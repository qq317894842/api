package com.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/20 16:50
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("航司维度统计数据")
public class CompanyLineData extends BaggageLineData {
    private String company;
}
