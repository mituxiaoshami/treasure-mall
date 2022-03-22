package com.example.treasuremall.componenets.log.aspect;

import com.example.treasuremall.componenets.log.LogRecord;
import com.example.treasuremall.componenets.log.express.AspectExpress;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 小沙弥
 * @description 日志切面组件
 * @date 2022/3/5 6:40 下午
 */
@Aspect
@Component
@Slf4j
public class LogRecordAspect {


    /**
     * 指定日志切面注解
     */
    @Pointcut("@annotation(com.example.treasuremall.componenets.log.LogRecord)")
    public void logRecordAnnotationMethods() {

    }


    /***
     * 拦截控制层的操作日志
     * @param joinPoint
     */
    @Around(value = "logRecordAnnotationMethods()")
    public Object recordLog(ProceedingJoinPoint joinPoint) {
        Object proceed;
        try {
            proceed = joinPoint.proceed();
            //后置处理
            saveLogAspect(joinPoint, null);
            return proceed;
        } catch (Throwable throwable) {
            saveLogAspect(joinPoint, throwable);
            throw new RuntimeException(throwable.getMessage());
        }
    }


    private void saveLogAspect(JoinPoint joinPoint, Throwable throwable) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        try {
            // 获取自定义注解
            LogRecord logRecord = methodSignature.getMethod().getAnnotation(LogRecord.class);
            Object spEl = AspectExpress.getSpEl(joinPoint, methodSignature, logRecord.successTemplate(), Object.class);
            System.out.println(spEl);
            if (log.isInfoEnabled()) {
                log.info(" SpelLog {}", spEl);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
