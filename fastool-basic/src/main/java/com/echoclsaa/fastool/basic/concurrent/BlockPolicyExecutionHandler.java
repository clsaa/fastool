package com.echoclsaa.fastool.basic.concurrent;


import com.echoclsaa.fastool.basic.exception.ExceptionUtils;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Block Policy.
 *
 * @author clsaa
 */
public class BlockPolicyExecutionHandler implements RejectedExecutionHandler {

    private String name;

    public BlockPolicyExecutionHandler(String name) {
        this.name = name;
    }

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            /**
             * 线程池需要执行的任务数
             */
            long taskCount = executor.getTaskCount();
            /**
             * 线程池在运行过程中已完成的任务数
             */
            long completedTaskCount = executor.getCompletedTaskCount();
            /**
             * 曾经创建过的最大线程数
             */
            long largestPoolSize = executor.getLargestPoolSize();
            /**
             * 线程池里的线程数量
             */
            long poolSize = executor.getPoolSize();
            /**
             * 线程池里活跃的线程数量
             */
            long activeCount = executor.getActiveCount();

            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            ExceptionUtils.throwException(e);
        }
    }
}
