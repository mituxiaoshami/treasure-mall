package com.example.treasuremall.api;

import com.example.treasuremall.componenets.disruptor.event.factory.OrderDisruptorEventFactory;
import com.example.treasuremall.componenets.disruptor.event.order.OrderDisruptorEvent;
import com.example.treasuremall.componenets.disruptor.handler.impl.HelloWorldDisruptorEventHandler;
import com.example.treasuremall.componenets.disruptor.process.DisruptorProcess;
import com.example.treasuremall.componenets.disruptor.translator.OrderDisruptorEventTranslator;
import com.example.treasuremall.componenets.parallel.executor.ParallelExecutor;
import com.example.treasuremall.componenets.parallel.process.ParallelProcessor;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author 小沙弥
 * @description 并发测试
 * @date 2021/8/17 3:36 下午
 */
public class ParallelTest {

    public static void main(String[] args) {

        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        // 测试计算和
        ParallelProcessor<Integer, Integer> disruptorProcessor = ParallelProcessor.buildDisruptorProcessor(new OrderDisruptorEventFactory(), new HelloWorldDisruptorEventHandler(), new OrderDisruptorEventTranslator());
        disruptorProcessor.execute(list);

    }




}
