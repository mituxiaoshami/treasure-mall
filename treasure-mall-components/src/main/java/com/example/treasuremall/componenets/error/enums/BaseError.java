package com.example.treasuremall.componenets.error.enums;

import com.example.treasuremall.componenets.error.exception.BaseException;

/**
 * @author 小沙弥
 * @description 基础错误枚举
 * @date 2022/3/10 4:34 下午
 */
public interface BaseError {

    /**
     * 获取异常code
     */
    int getCode();


    /**
     * 获取错误信息
     */
    String getMessage();

}
