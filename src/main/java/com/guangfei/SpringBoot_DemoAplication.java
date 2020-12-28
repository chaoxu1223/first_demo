package com.guangfei;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.*;

@SpringBootApplication(exclude={org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class})
@MapperScan(value = {"com.guangfei.business.mapper"})
@ComponentScan(basePackages = {"com.guangfei"})
@EnableScheduling
@EnableAsync
@EnableRabbit
public class SpringBoot_DemoAplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot_DemoAplication.class,args);
    }

    /*int corePoolSize,
    int maximumPoolSize,
    long keepAliveTime,
    TimeUnit unit,
    BlockingQueue<Runnable> workQueue,
    ThreadFactory threadFactory,
    RejectedExecutionHandler handler*/

    @Bean(name="myCustomThread")
    public Executor myCustomThread(){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(8,20,
                        1000,TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        return poolExecutor;
    }
 }
