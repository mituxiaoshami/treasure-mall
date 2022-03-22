package com.example.treasuremall.componenets.disruptor.event;

import com.example.treasuremall.componenets.util.SerialNumberUtil;

/**
 * @author 小沙弥
 * @description Disruptor 事件
 * @date 2021/8/24 3:09 下午
 */
public class DisruptorEvent {

    /**
     * 自动生成id,确定唯一性
     */
    private final String autoGenerateId;

    public DisruptorEvent() {
        this(generateAutoId());
    }

    public DisruptorEvent(String autoGenerateId) {
        this.autoGenerateId = autoGenerateId;
    }

    private static String generateAutoId() {
        return SerialNumberUtil.getInstance().create(SerialNumberUtil.SerialNumberPrefixConstant.SERIAL_NUMBER_DISRUPTOR_CODE_PREFIX);
    }

    /**
     * 获取事件唯一编码
     */
    public String getAutoGenerateId() {
        return autoGenerateId;
    }
}
