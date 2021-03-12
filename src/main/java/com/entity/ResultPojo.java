package com.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h3>iflashbuy</h3>
 * <p>响应结果对象</p>
 *
 * @author : mrcode@126.com
 * @date : 2020-05-24 14:32
 **/
@Data
@Builder
@ApiModel("响应结果对象")
@AllArgsConstructor
@NoArgsConstructor
public class ResultPojo<T> {
//    @ApiModelProperty("状态码")
//    private String code;
    @ApiModelProperty("状态描述")
    private String message;

    private boolean success;

    private String tick;

    @ApiModelProperty("响应数据")
    private T data;
    @Override
    public String toString(){
        try {
            return new ObjectMapper().writeValueAsString(this);
        }catch (Exception e){}
        return super.toString();
    }
}
