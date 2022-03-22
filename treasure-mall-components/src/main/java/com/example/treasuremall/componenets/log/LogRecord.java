package com.example.treasuremall.componenets.log;

import java.lang.annotation.*;

/**
 * @author 小沙弥
 * @description 业务操作日志注解
 * @date 2022/1/26 2:40 下午
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogRecord {

    /**
     * 成功的操作日志文本模板
     */
    String successTemplate();


    /**
     * 失败的操作日志文本模板
     */
    String failTemplate() default "";


    /**
     * 操作日志的执行人
     */
    String operator() default "";



    /**
     * 操作日志绑定的业务对象标识
     */
    String bizNo() default "";




}
