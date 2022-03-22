package com.example.treasuremall.componenets.disruptor.handler.impl;

import com.example.treasuremall.componenets.disruptor.event.order.OrderDisruptorEvent;
import com.example.treasuremall.componenets.disruptor.handler.DisruptorEventHandler;

/**
 * @author 小沙弥
 * @description 测试Disruptor
 * @date 2021/8/25 3:05 下午
 */
public class HelloWorldDisruptorEventHandler implements DisruptorEventHandler<OrderDisruptorEvent> {

    @Override
    public void onEvent(OrderDisruptorEvent orderDisruptorEvent, long l, boolean b) throws Exception {
        System.out.println(orderDisruptorEvent.getOrderNo());
    }

}
