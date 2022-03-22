package com.example.treasuremall.componenets.error.exception.impl;

import com.example.treasuremall.componenets.error.enums.BaseError;
import com.example.treasuremall.componenets.error.exception.BaseException;

/**
 * @author 小沙弥
 * @description 业务错误
 * @date 2022/3/10 5:24 下午
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(BaseError baseError, Object[] args, String message) {
        super(baseError, args, message);
    }

    public BusinessException(BaseError baseError, Object[] args, String message, Throwable cause) {
        super(baseError, args, message, cause);
    }

}
