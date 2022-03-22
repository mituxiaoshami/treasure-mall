package com.example.treasuremall.componenets.disruptor.translator;

import com.example.treasuremall.componenets.disruptor.event.order.OrderDisruptorEvent;
import com.lmax.disruptor.EventTranslator;

/**
 * @author 小沙弥
 * @description 事件发布类
 * @date 2021/8/25 5:19 下午
 */
public class OrderDisruptorEventTranslator implements EventTranslator<OrderDisruptorEvent> {

    @Override
    public void translateTo(OrderDisruptorEvent orderDisruptorEvent, long l) {
        System.out.println("订单DisruptorEvent发布-------------------");
        orderDisruptorEvent.setOrderNo("123");
    }

}
