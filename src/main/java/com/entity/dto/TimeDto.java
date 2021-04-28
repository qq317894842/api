package com.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/25 17:06
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("重庆机场-钻取数据时传递time参数")
public class TimeDto {

    private String time;
}
