package com.example.treasuremall.componenets.disruptor.event.factory;

import com.example.treasuremall.componenets.disruptor.event.order.OrderDisruptorEvent;
import com.lmax.disruptor.EventFactory;

/**
 * @author 小沙弥
 * @description 订单事件工厂
 * @date 2021/8/25 4:40 下午
 */
public class OrderDisruptorEventFactory implements EventFactory<OrderDisruptorEvent> {

    @Override
    public OrderDisruptorEvent newInstance() {
        return new OrderDisruptorEvent();
    }

}
