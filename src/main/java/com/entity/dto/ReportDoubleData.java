package com.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/24 10:49
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("效率数据")
public class ReportDoubleData {
    private double count;
    private String time;
    private String type;
}
