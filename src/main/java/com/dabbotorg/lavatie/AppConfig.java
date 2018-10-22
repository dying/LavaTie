package com.dabbotorg.lavatie;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.TaskUtils;

@Configuration
@EnableAsync(proxyTargetClass = true)
@EnableScheduling
@EnableAutoConfiguration
public class AppConfig {
    @Bean(name = "asyncTaskScheduler")
    public TaskScheduler createTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(4);
        taskScheduler.setDaemon(true);
        taskScheduler.initialize();
        return taskScheduler;
    }

    @Bean(name = "syncAppplicationEventMulticaster")
    ApplicationEventMulticaster createApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(1);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(1_000);
        taskExecutor.setDaemon(true);
        taskExecutor.initialize();
        eventMulticaster.setTaskExecutor(taskExecutor);
        eventMulticaster.setErrorHandler(TaskUtils.LOG_AND_PROPAGATE_ERROR_HANDLER);
        return eventMulticaster;
    }
}
