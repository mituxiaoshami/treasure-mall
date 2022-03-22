package com.example.treasuremall.componenets.parallel.executor.impl;

import com.example.treasuremall.componenets.parallel.executor.ParallelExecutor;

import java.util.List;

/**
 * @author 小沙弥
 * @description disruptor 并发执行器
 * @date 2022/2/10 5:04 下午
 */
public class DisruptorParallelExecutor<T, R> implements ParallelExecutor<T, R> {

    static {

    }

    @Override
    public R executeResult(List<T> parallelData) {
        return null;
    }

    @Override
    public void execute(List<T> parallelData) {

    }
}
