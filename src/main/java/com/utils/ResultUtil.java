package com.utils;

import com.constant.ResultCode;
import com.entity.ResultPojo;

/**
 * <h3>iflashbuy</h3>
 * <p>结果处理工具</p>
 *
 * @author : mrcode@126.com
 * @date : 2020-05-25 15:56
 **/
public class ResultUtil<T> {

    public static ResultPojo mix(ResultCode state, Object data) {
        return ResultPojo.builder().success(true)
//                .code(state.getCode())
                .message(state.getMsg())
                .data(data)
                .build();
    }

    public ResultPojo reData(ResultCode state, T data) {
        return ResultPojo.builder().success(true)
//                .code(state.getCode())
                .message(state.getMsg())
                .data(data)
                .build();
    }

    public static ResultPojo mix(ResultCode state) {
        return ResultPojo.builder().success(true)
//                .code(state.getCode())
                .message(state.getMsg())
                .build();
    }
}
