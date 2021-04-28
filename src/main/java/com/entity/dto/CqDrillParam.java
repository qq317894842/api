package com.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/25 13:38
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("重庆机场-钻取数据时传递的参数")
public class CqDrillParam {

    private String company;

    private String time;
}
