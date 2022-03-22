package com.example.treasuremall.componenets.parallel.model.impl;

import com.example.treasuremall.componenets.disruptor.event.DisruptorEvent;
import com.example.treasuremall.componenets.disruptor.process.DisruptorProcess;
import com.example.treasuremall.componenets.parallel.executor.ParallelExecutor;
import com.example.treasuremall.componenets.parallel.model.ParallelExecutorModel;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author 小沙弥
 * @description disruptor并发执行模式
 * @date 2022/1/24 4:29 下午
 */
public class DisruptorExecutorModel<T, R, E extends DisruptorEvent> implements ParallelExecutorModel<T, R> {

    /**
     * disruptor事件工厂
     */
    private EventFactory<E> eventFactory;

    /**
     * disruptor事件执行
     */
    private EventHandler<E> eventEventHandler;

    /**
     * disruptor事件发布
     */
    private EventTranslator<E> eventTranslator;


    public DisruptorExecutorModel(EventFactory<E> eventFactory, EventHandler<E> eventEventHandler, EventTranslator<E> eventTranslator) {
        this.eventFactory = eventFactory;
        this.eventEventHandler = eventEventHandler;
        this.eventTranslator = eventTranslator;
    }


    @Override
    public List<R> executeResult(List<List<T>> parallelDataList, ParallelExecutor<T, R> parallelExecutor) {
        if (CollectionUtils.isEmpty(parallelDataList)) {
            return Collections.emptyList();
        }
        System.out.println("Disruptor is not Support execute result");
        return null;
    }


    @Override
    public void execute(List<List<T>> parallelDataList, ParallelExecutor<T, R> parallelExecutor) {
        DisruptorProcess<E> disruptorProcess = DisruptorProcess.buildDefaultDisruptor(eventFactory).addHandleEvent(eventEventHandler);
        disruptorProcess.getDisruptor().start();
        disruptorProcess.getDisruptor().publishEvent(eventTranslator);
        disruptorProcess.getDisruptor().shutdown();
    }

}
