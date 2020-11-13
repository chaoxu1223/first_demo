package com.guangfei.business.controller;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduleTask {

    /*@Scheduled(cron = "0/1 * * * * ?")*/
    /*@Async(value = "myCustomThread")*/
    public void doTask(){
    try {
            System.out.println(new Date()+"++++++++++++我喜欢你,广菲++++++++++");

            TimeUnit.SECONDS.sleep(5);

            System.out.println(new Date()+">>>>>>>>俺睡结束了。。。。。"+Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
