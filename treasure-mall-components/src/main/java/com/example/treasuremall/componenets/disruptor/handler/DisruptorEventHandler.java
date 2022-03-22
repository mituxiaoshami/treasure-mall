package com.example.treasuremall.componenets.disruptor.handler;

import com.example.treasuremall.componenets.disruptor.event.DisruptorEvent;
import com.lmax.disruptor.EventHandler;

/**
 * @author 小沙弥
 * @description Disruptor 事件处理器
 * @date 2021/8/24 3:15 下午
 */
public interface DisruptorEventHandler<E extends DisruptorEvent> extends EventHandler<E> {


}
