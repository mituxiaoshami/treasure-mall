package com.example.treasuremall.componenets.error.asserts.impl;

import com.example.treasuremall.componenets.error.asserts.Assert;
import com.example.treasuremall.componenets.error.enums.BaseError;
import com.example.treasuremall.componenets.error.exception.BaseException;
import com.example.treasuremall.componenets.error.exception.impl.BusinessException;

import java.text.MessageFormat;

/**
 * @author 小沙弥
 * @description 业务错误断言
 * @date 2022/3/10 5:22 下午
 */
public interface BusinessExceptionAssert extends BaseError, Assert {

    @Override
    default BaseException runException(Object... args) {
        return new BusinessException(this, args, MessageFormat.format(this.getMessage(), args));
    }

    @Override
    default BaseException runException(Throwable t, Object... args) {
        return new BusinessException(this, args, MessageFormat.format(this.getMessage(), args), t);
    }


}
