package com.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Auther: HuangRui
 * @Date: 2021/3/10 11:52
 * @Description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("查询参数")
public class QueryParam {
    @ApiModelProperty("查询维度 航班视角(0：航司，1：航站楼) 资源视角(0:操作员，1：设备) 行李视角:(0:行李类别 1：行李状态)")
    private String type;
    @ApiModelProperty("开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginTime;
    @ApiModelProperty("结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;
    @ApiModelProperty("颗粒度 1：年   2：月  3：周   4：小时 0: 日")
    private int granularity;
    @ApiModelProperty("跟踪节点 1-12 ")
    private List<Integer> traceList;
    @ApiModelProperty("航站楼 0:离港  1:进港")
    private int terminal;

}
