package com.example.treasuremall.componenets.error.asserts;

import com.example.treasuremall.componenets.error.exception.BaseException;

/**
 * @author 小沙弥
 * @description 断言
 * @date 2022/3/10 4:06 下午
 */
public interface Assert {

    /**
     * 创建异常
     * @param args 填充参数
     * @return 抛出异常
     */
    BaseException runException(Object... args);


    /**
     * 创建异常
     * @param t 抛出异常
     * @param args 错误信息占位符对应的参数列表
     * @return 错误
     */
    BaseException runException(Throwable t, Object... args);


    /**
     * 断言对象obj非空。如果对象obj为空，则抛出异常
     *
     * @param obj 待判断对象
     */
    default void assertNotNull(Object obj) {
        if (obj == null) {
            throw runException(obj);
        }
    }


    /**
     * 断言对象obj非空。如果对象obj为空，则抛出异常
     * 异常信息message支持传递参数方式，避免在判断之前进行字符串拼接操作
     *
     * @param obj 待判断对象
     * @param args message占位符对应的参数列表
     */
    default void assertNotNull(Object obj, Object... args) {
        if (obj == null) {
            throw runException(args);
        }
    }

}
