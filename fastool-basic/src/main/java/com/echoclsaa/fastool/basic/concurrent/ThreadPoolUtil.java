package com.echoclsaa.fastool.basic.concurrent;

import com.echoclsaa.fastool.basic.logger.Logger;
import com.echoclsaa.fastool.basic.logger.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author clsaa
 */
public class ThreadPoolUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolUtil.class);

    private ThreadPoolUtil() {
    }


    public static ListeningExecutorService createListeningExecutor(String name,
                                                                   int corePoolSize,
                                                                   int maxPoolSize,
                                                                   BlockingQueue<Runnable> workQueue) {
        ExecutorService executorService = createExecutor(name, corePoolSize, maxPoolSize, workQueue);
        ListeningExecutorService listeningExecutorService = new ListeningDecorator(executorService);
        return listeningExecutorService;
    }


    public static ExecutorService createExecutor(String name,
                                                 int corePoolSize,
                                                 int maxPoolSize,
                                                 BlockingQueue<Runnable> workQueue) {
        ThreadFactory threadFactory = createThreadFactory(name);

        return new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                10L,
                TimeUnit.SECONDS,
                workQueue,
                threadFactory,
                new BlockPolicyExecutionHandler(name)
        );
    }

    public static ScheduledExecutorService scheduledExecutorService() {
        return executor;
    }

    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
            2,
            createThreadFactory("ScheduledExecutor pool"),
            new BlockPolicyExecutionHandler("Fastool-ScheduledExecutor pool")
    );

    private static ThreadFactory createThreadFactory(String name) {
        return new NamedThreadFactory("Fastool-" + name, false, (t, e) -> LOGGER.error(t.getName() + " e", e));
    }

}
