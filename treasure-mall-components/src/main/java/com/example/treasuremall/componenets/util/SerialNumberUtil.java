package com.example.treasuremall.componenets.util;

import com.google.common.base.Supplier;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 业务编号的util(采取前缀+时间戳+序列号的方式生成)
 * @author 小沙弥
 * @date 2020/10/21 1:44 PM
 **/
public final class SerialNumberUtil {

    /**
     * 缓存时间字符串和对应该时间内的序列计数
     * 将当前的时间精确到秒作为时间字符串，也就是每秒都有对应的序列计数
     * 两秒之后该缓存项被清除，因为两秒过后肯定该缓存项永远用不上
     **/
    private final static LoadingCache<String, AtomicInteger> SERIAL_NUMBER_CACHE = CacheBuilder.newBuilder()
                                                                                               .expireAfterWrite(2, TimeUnit.SECONDS)
                                                                                               .build(CacheLoader.from((Supplier<AtomicInteger>) AtomicInteger::new));
    /**
     * 每秒序列计数的字符串长度，设为四位（0001 ~ 9999），如果每秒需要产生达到上万个序列计数，则将此数字加大
     **/
    private final static int SERIAL_NUMBER_LEN   = 4;

    /**
     * 生成
     **/
    public String create(String prefix) {

        // 如果没有传递前缀的话用默认取空字符串
        String numberPrefix = StringUtils.defaultString(prefix);
        // 中间的内容取当前时间
        String numberCenter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        // 通过当前的时间获取序列号
        int serialNumber;
        try {
            SERIAL_NUMBER_CACHE.get(numberCenter).set((int)(Math.random() * (9999 - 1000 + 1) + 1000));
            serialNumber = SERIAL_NUMBER_CACHE.get(numberCenter).get();
        } catch (ExecutionException e) {
            throw new IllegalStateException("Could not get serial number", e);
        }
        // 后缀取自增的序列号
        String numberSuffix = StringUtils.leftPad(serialNumber + "", SERIAL_NUMBER_LEN, "0");
        return numberPrefix + numberCenter + numberSuffix;
    }

    private SerialNumberUtil() {

    }

    /**
     * 获取实例
     **/
    private static class Singleton {
        private static final SerialNumberUtil INSTANCE = new SerialNumberUtil();
    }

    /**
     * 获取单例生成器
     **/
    public static SerialNumberUtil getInstance() {
        return Singleton.INSTANCE;
    }


    /**
     * @description: 自动生成前缀
     * @author 小沙弥
     * @date 2021/8/24 4:02 下午
     */
    public static class SerialNumberPrefixConstant {

        /**
         * DISRUPTOR 前缀
         **/
        public static String SERIAL_NUMBER_DISRUPTOR_CODE_PREFIX = "S";

    }


    public static void main(String[] args) {

        for (int i = 0; i <= 1000; i++) {
            System.out.println(SerialNumberUtil.getInstance().create(SerialNumberPrefixConstant.SERIAL_NUMBER_DISRUPTOR_CODE_PREFIX));
        }
    }




}
