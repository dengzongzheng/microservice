package com.dzz.policy.service.config.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 异步线程池配置
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 09:38
 */
@Slf4j
@Configuration
@EnableAsync(proxyTargetClass = true)
public class AsyncConfig {

    @Bean(name="asyncExecutor")
    public TaskExecutor taskExecutor() {

        //定义线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        //核心线程池
        taskExecutor.setCorePoolSize(10);
        //设置最大核心线程
        taskExecutor.setMaxPoolSize(100);
        //线程队列最大线程数
        taskExecutor.setQueueCapacity(100);
        taskExecutor.afterPropertiesSet();
        //线程组名称
        taskExecutor.setThreadGroupName("通用线程组名称");
        taskExecutor.initialize();
        return taskExecutor;
    }
}
