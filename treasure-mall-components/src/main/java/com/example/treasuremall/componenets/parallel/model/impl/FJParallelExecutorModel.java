package com.example.treasuremall.componenets.parallel.model.impl;

import com.example.treasuremall.componenets.parallel.executor.ParallelExecutor;
import com.example.treasuremall.componenets.parallel.model.ParallelExecutorModel;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author 小沙弥
 * @description fork/join并发执行模式
 * @date 2021/8/16 5:05 下午
 */
public class FJParallelExecutorModel<T, R> implements ParallelExecutorModel<T, R> {

    /**
     * ForkJoinPool线程池
     */
    private final ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    @Override
    public List<R> executeResult(List<List<T>> parallelDataList, ParallelExecutor<T, R> parallelExecutor) {
        if (CollectionUtils.isEmpty(parallelDataList)) {
            return Collections.emptyList();
        }
        //分片完成后并行执行所有记录
        if (parallelDataList.size() == 1) {
            //数量为1，不需要额外线程
            return Lists.newArrayList(parallelExecutor.executeResult(parallelDataList.get(0)));
        }
        //并行执行
        ForkJoinExecuteResultTask forkJoinExecuteResultTask = new ForkJoinExecuteResultTask(parallelDataList, parallelExecutor);
        return forkJoinPool.invoke(forkJoinExecuteResultTask);
    }

    @Override
    public void execute(List<List<T>> parallelDataList, ParallelExecutor<T, R> parallelExecutor) {
        if (CollectionUtils.isEmpty(parallelDataList)) {
            return;
        }
        //分片完成后并行执行所有记录
        if (parallelDataList.size() == 1) {
            //数量为1，不需要额外线程
            parallelExecutor.execute(parallelDataList.get(0));
            return;
        }
        //并行执行
        ForkJoinExecuteTask forkJoinExecuteTask = new ForkJoinExecuteTask(parallelDataList, parallelExecutor);
        forkJoinPool.execute(forkJoinExecuteTask);
    }


    /**
     * @description: 内部类，用来执行fj任务
     * RecursiveAction：用于没有返回结果的任务
     * RecursiveTask：用于有返回结果的任务
     */
    private class ForkJoinExecuteResultTask extends RecursiveTask<List<R>> {

        /**
         * 业务执行数据
         */
        private final List<List<T>> parallelDataList;

        /**
         * 业务执行器
         */
        private final ParallelExecutor<T, R> parallelExecutor;


        ForkJoinExecuteResultTask(List<List<T>> parallelDataList, ParallelExecutor<T, R> parallelExecutor) {
            this.parallelDataList = parallelDataList;
            this.parallelExecutor = parallelExecutor;
        }

        @Override
        protected List<R> compute() {
            if (parallelDataList.size() == 1) {
                //数量为0直接执行,否则通过fork/join
                return Lists.newArrayList(parallelExecutor.executeResult(parallelDataList.get(0)));
            }
            // 二分
            int halfSize = parallelDataList.size() / 2;
            ForkJoinExecuteResultTask leftTask = new ForkJoinExecuteResultTask(parallelDataList.subList(0, halfSize), parallelExecutor);
            ForkJoinExecuteResultTask rightTask = new ForkJoinExecuteResultTask(parallelDataList.subList(halfSize, parallelDataList.size()),
                    parallelExecutor);
            // 子任务在调用fork方法时，又会进入compute方法，看看当前子任务是否需要继续分割，如果不需要则执行当前子任务并返回结果
            leftTask.fork();
            rightTask.fork();
            // 使用join方法会等待子任务执行完并得到返回结果
            return merge(leftTask.join(), rightTask.join());
        }

        /**
         * 合并结果
         * @param result1 结果1
         * @param result2 结果2
         * @return 总的结果
         */
        public List<R> merge(List<R> result1, List<R> result2) {
            List<R> mergeResult = Lists.newArrayList();
            if (!CollectionUtils.isEmpty(result1)) {
                mergeResult.addAll(result1);
            }
            if (!CollectionUtils.isEmpty(result2)) {
                mergeResult.addAll(result2);
            }
            return mergeResult;
        }

    }



    /**
     * @description: 内部类，用来执行fj任务
     * RecursiveAction：用于没有返回结果的任务
     * RecursiveTask：用于有返回结果的任务
     */
    private class ForkJoinExecuteTask extends RecursiveAction {

        /**
         * 业务执行数据
         */
        private final List<List<T>> parallelDataList;

        /**
         * 业务执行器
         */
        private final ParallelExecutor<T, R> parallelExecutor;

        ForkJoinExecuteTask(List<List<T>> parallelDataList, ParallelExecutor<T, R> parallelExecutor) {
            this.parallelDataList = parallelDataList;
            this.parallelExecutor = parallelExecutor;
        }

        @Override
        protected void compute() {
            if (parallelDataList.size() == 1) {
                //数量为0直接执行,否则通过fork/join
                parallelExecutor.execute(parallelDataList.get(0));
                return;
            }
            // 二分
            int halfSize = parallelDataList.size() / 2;
            ForkJoinExecuteTask leftTask = new ForkJoinExecuteTask(parallelDataList.subList(0, halfSize), parallelExecutor);
            ForkJoinExecuteTask rightTask = new ForkJoinExecuteTask(parallelDataList.subList(halfSize, parallelDataList.size()),
                    parallelExecutor);
            // 子任务在调用fork方法时，又会进入compute方法，看看当前子任务是否需要继续分割，如果不需要则执行当前子任务并返回结果
            leftTask.fork();
            rightTask.fork();
        }
    }


}
