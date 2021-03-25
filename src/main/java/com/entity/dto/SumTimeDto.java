package com.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/24 10:46
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("行李按维度操作时间之和")
public class SumTimeDto {
    private int sum;
    private String type;
}
