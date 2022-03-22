package com.example.treasuremall.componenets.disruptor.process;

import com.example.treasuremall.componenets.disruptor.event.DisruptorEvent;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author 小沙弥
 * @description Disruptor执行器
 * @date 2021/8/25 3:43 下午
 */
public class DisruptorProcess<E extends DisruptorEvent> {

    /**
     * Disruptor执行
     */
    private final Disruptor<E> disruptor;

    /**
     * 默认情况下的 ringBuffer 大小 1024
     */
    private static final int DEFAULT_DISRUPTOR_SIZE = 1 << 10;

    /**
     * 生产者模式
     */
    private static final ProducerType DEFAULT_PRODUCER_TYPE = ProducerType.SINGLE;


    /**
     * 等待策略 ringBuffer满了的等待策略
     */
    private static final WaitStrategy DEFAULT_WAIT_STRATEGY = new BusySpinWaitStrategy();

    /**
     * 消费组
     */
    private EventHandlerGroup<E> handlerGroup;


    /**
     * 添加Disruptor事件处理
     * @param eventHandler 事件处理类
     * @return Disruptor处理器
     */
    @SafeVarargs
    public final DisruptorProcess<E> addHandleEvent(EventHandler<E>... eventHandler) {
        if (Objects.isNull(eventHandler) || eventHandler.length == 0) {
            throw new RuntimeException("eventHandler can not be null or empty");
        }
        this.handlerGroup = disruptor.handleEventsWith(eventHandler);
        return this;
    }


    /**
     * 添加Disruptor后事件处理
     * @param eventHandler 事件处理类
     * @return Disruptor处理器
     */
    @SafeVarargs
    public final DisruptorProcess<E> addThenHandleEvent(EventHandler<E>... eventHandler) {
        if (Objects.isNull(handlerGroup)) {
            throw new RuntimeException("handlerGroup can not be null");
        }
        this.handlerGroup.then(eventHandler);
        return this;
    }


    // ------------------------ 构建Disruptor -----------------------------------
    /**
     * 默认情况下构建Disruptor执行器
     */
    public static <T extends DisruptorEvent> DisruptorProcess<T> buildDefaultDisruptor(EventFactory<T> eventFactory) {
        return buildDisruptor(eventFactory, new DefaultDisruptorThreadFactory(), DEFAULT_DISRUPTOR_SIZE, DEFAULT_PRODUCER_TYPE, DEFAULT_WAIT_STRATEGY);
    }

    /**
     * 带参数的构建Disruptor执行器
     * @param threadFactory 线程工厂
     * @param disruptorSize ringBuffer
     * @return Disruptor执行器
     */
    public static <T extends DisruptorEvent> DisruptorProcess<T> buildDisruptor(EventFactory<T> eventFactory, ThreadFactory threadFactory, int disruptorSize, ProducerType producerType, WaitStrategy waitStrategy) {
        return new DisruptorProcess<>(eventFactory, threadFactory, disruptorSize, producerType, waitStrategy);
    }


    /**
     * @description: 构建Disruptor执行器
     * @param threadFactory 线程工厂
     * @param disruptorSize ringBuffer 大小
     * @date 2021/8/25 4:18 下午
     */
    public DisruptorProcess(EventFactory<E> eventFactory, ThreadFactory threadFactory, int disruptorSize, ProducerType producerType, WaitStrategy waitStrategy) {
        this.disruptor = new Disruptor<>(eventFactory, disruptorSize, threadFactory, producerType, waitStrategy);
    }

    // ------------------------ 构建Disruptor -----------------------------------

    /**
     * @description: 默认的线程工厂
     */
    private static class DefaultDisruptorThreadFactory implements ThreadFactory{

        /**
         * 线程ID索引下标
         */
        private final LongAdder index = new LongAdder();

        @Override
        public Thread newThread(Runnable r) {
            // 自增
            index.increment();
            return new Thread(null, r, "default-disruptor-thread-" + index.toString());
        }
    }


    /**
     * 获取Disruptor
     */
    public Disruptor<E> getDisruptor() {
        return disruptor;
    }
}
