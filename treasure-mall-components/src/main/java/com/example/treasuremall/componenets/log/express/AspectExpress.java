package com.example.treasuremall.componenets.log.express;

import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.expression.CachedExpressionEvaluator;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author 小沙弥
 * @description 自定义SpEL解析器
 * @date 2022/3/5 6:59 下午
 */
public class AspectExpress extends CachedExpressionEvaluator {



    /**
     * 获取spel 表达式解析后的操作日志
     * @param joinPoint 切点
     * @param methodSignature 方法
     * @param expression spel 表达式
     * @param <T> 返回泛型
     * @param clazz 返回类
     */
    public static <T> T getSpEl(JoinPoint joinPoint, MethodSignature methodSignature, String expression, Class<T> clazz){
        EvaluationContext context = getContext(joinPoint.getArgs(), methodSignature.getMethod());
        return getValue(context, expression, clazz);
    }

    /**
     * 获取spel 定义的参数值
     *
     * @param context 参数容器
     * @param key     key
     * @param clazz   需要返回的类型
     * @param <T>     返回泛型
     * @return 参数值
     */
    private static <T> T getValue(EvaluationContext context, String key, Class<T> clazz) {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        // 在SpEL中使用表达式模板
        Expression expression = spelExpressionParser.parseExpression(key);
        return expression.getValue(context, clazz);
    }


    /**
     * 获取参数容器
     *
     * @param arguments       方法的参数列表
     * @param signatureMethod 被执行的方法体
     * @return 装载参数的容器
     */
    private static EvaluationContext getContext(Object[] arguments, Method signatureMethod) {
        String[] parameterNames = new LocalVariableTableParameterNameDiscoverer().getParameterNames(signatureMethod);
        if (parameterNames == null) {
            throw new RuntimeException("参数列表不能为null");
        }
        EvaluationContext context = new StandardEvaluationContext();
        Map<String, Object> paramValue = Maps.newConcurrentMap();
        for (int i = 0; i < arguments.length; i++) {
            paramValue.put(parameterNames[i], arguments[i]);
        }
        context.setVariable("paramMap" , paramValue);
        return context;
    }

}

