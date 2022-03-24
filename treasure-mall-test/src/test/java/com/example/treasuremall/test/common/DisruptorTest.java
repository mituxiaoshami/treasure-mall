package com.example.treasuremall.test.common;

import com.example.treasuremall.componenets.disruptor.event.factory.OrderDisruptorEventFactory;
import com.example.treasuremall.componenets.disruptor.event.order.OrderDisruptorEvent;
import com.example.treasuremall.componenets.disruptor.handler.impl.HelloWorldDisruptorEventHandler;
import com.example.treasuremall.componenets.disruptor.process.DisruptorProcess;
import com.example.treasuremall.componenets.disruptor.translator.OrderDisruptorEventTranslator;

/**
 * @author 小沙弥
 * @description Disruptor 测试类
 * @date 2021/8/25 3:09 下午
 */
public class DisruptorTest {

    public static void main(String[] args) {

        DisruptorProcess<OrderDisruptorEvent> disruptorProcess = DisruptorProcess.buildDefaultDisruptor(new OrderDisruptorEventFactory()).addHandleEvent(new HelloWorldDisruptorEventHandler());
        disruptorProcess.getDisruptor().start();
        disruptorProcess.getDisruptor().publishEvent(new OrderDisruptorEventTranslator());
        disruptorProcess.getDisruptor().shutdown();

    }

}
