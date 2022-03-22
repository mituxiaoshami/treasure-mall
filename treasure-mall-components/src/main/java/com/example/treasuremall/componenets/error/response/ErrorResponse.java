package com.example.treasuremall.componenets.error.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小沙弥
 * @description 错误的返回值
 * @date 2022/3/22 4:30 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {


    /**
     * 错误码
     */
    private int code;


    /**
     * 错误信息
     */
    private String message;


}
