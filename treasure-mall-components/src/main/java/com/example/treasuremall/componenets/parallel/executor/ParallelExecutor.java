package com.example.treasuremall.componenets.parallel.executor;

import java.util.List;

/**
 * @author 小沙弥
 * @description 并发执行器
 * @param <T> 入参类型
 * @param <R> 返回值类型
 * @date 2021/8/16 4:17 下午
 */
public interface ParallelExecutor<T, R> {

    /**
     * 需要结果返回的并发执行
     *
     * @param parallelData 数据
     * @return 执行结果
     */
    R executeResult(List<T> parallelData);


    /**
     * @description: 不需要结果的并发执行
     *
     * @param parallelData 数据
     * @date 2021/8/24 4:26 下午
     */
    void execute(List<T> parallelData);

}
