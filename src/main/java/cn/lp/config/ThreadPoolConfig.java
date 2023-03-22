package cn.lp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@Component
public class ThreadPoolConfig {
    @Bean("threadPoolExecutor")
    /**
     * int corePoolSize,//核心线程池大小
     * int maximumPoolSize,//最大线程池大小
     * long keepAliveTime,//超时了没有人调用就会释放
     * TimeUnit unit,//超时单位
     * BlockingQueue<Runnable> workQueue,//阻塞队列
     * ThreadFactory threadFactory,//线程工厂，创建线程的，一般不用动
     * RejectedExecutionHandler handler//拒绝策略
     */
    public ThreadPoolExecutor getInstance() {
        return new ThreadPoolExecutor(2, 6, 6, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
