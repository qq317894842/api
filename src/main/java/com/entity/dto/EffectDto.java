package com.entity.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: HuangRui
 * @Date: 2021/4/23 17:51
 * @Description:
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("节点效率数据")
public class EffectDto {

    private String node;

    private Double avgTime;

    private Double maxTime;

    private Double minTime;

    public void setAvgTime(Double avgTime) {

        this.avgTime = avgTime/60;
        this.avgTime = this.avgTime<0?0:this.avgTime;
    }

    public void setMaxTime(Double maxTime) {
        this.maxTime = maxTime/60;
        this.maxTime = this.maxTime<0?0:this.maxTime;
    }

    public void setMinTime(Double minTime) {
        this.minTime = minTime/60;
        this.minTime = this.minTime<0?0:this.minTime;
    }
}
