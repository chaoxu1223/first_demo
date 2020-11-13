package com.guangfei.business.controller;


import com.guangfei.business.entity.Party;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq/get")
@Api(tags="获取mq消息")
@Slf4j
@RabbitListener(queues = {"one.ttl.queue"})
public class MqGetMsgController {

    /**
     *监听消息对象消息
     */
    @RabbitHandler
    public void listenMsg(Party party){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~party="+party);
    }

    /**
     *监听字符串消息
     */
    @RabbitHandler
    public void listenMsg(String str){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~str="+str);
    }


}
