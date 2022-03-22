package com.example.treasuremall.componenets.error.exception;

import com.example.treasuremall.componenets.error.enums.BaseError;
import lombok.Data;

/**
 * @author 小沙弥
 * @description 自定义异常
 * @date 2022/3/10 4:09 下午
 */
@Data
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误枚举
     */
    private final BaseError baseError;


    /**
     * 错误信息占位符对应的参数列表
     */
    private final Object[] args;


    /**
     * 错误信息
     */
    private final String message;


    /**
     * 错误
     */
    private final Throwable throwable;


    public BaseException(BaseError baseError, Object[] args, String message) {
        this.baseError = baseError;
        this.args = args;
        this.message = message;
        this.throwable = null;
    }

    public BaseException(BaseError baseError, Object[] args, String message, Throwable cause) {
        this.baseError = baseError;
        this.args = args;
        this.message = message;
        this.throwable = cause;
    }

}
