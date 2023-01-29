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
    public  ThreadPoolExecutor getInstance(){
        return new ThreadPoolExecutor(2,6,6, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
