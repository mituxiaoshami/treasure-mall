package com.example.treasuremall.componenets.error;

import com.example.treasuremall.componenets.error.constant.CommonResponseEnum;
import com.example.treasuremall.componenets.error.exception.BaseException;
import com.example.treasuremall.componenets.error.exception.impl.BusinessException;
import com.example.treasuremall.componenets.error.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 小沙弥
 * @description 统一异常处理器类
 * @date 2022/3/21 7:44 下午
 */
@Slf4j
@Component
@ControllerAdvice
@ConditionalOnWebApplication
@ConditionalOnMissingBean(UnifiedExceptionHandler.class)
public class UnifiedExceptionHandler {


    /**
     * 业务异常
     * @param baseException 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ErrorResponse handleBusinessException(BaseException baseException) {
        log.error(baseException.getMessage(), baseException);
        return new ErrorResponse(baseException.getBaseError().getCode(), baseException.getBaseError().getMessage());
    }


    /**
     * 自定义异常
     * @param baseException 自定义异常
     * @return 异常结果
     */
    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public ErrorResponse handleBaseException(BaseException baseException) {
        log.error(baseException.getMessage(), baseException);
        return new ErrorResponse(baseException.getBaseError().getCode(), baseException.getBaseError().getMessage());
    }


    /**
     * 未定义异常(未知异常)
     * @param exception 异常
     * @return 异常结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorResponse handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorResponse(CommonResponseEnum.SERVER_ERROR.getCode(), exception.getMessage());
    }




}
