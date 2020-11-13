package com.guangfei.business.controller;

import com.guangfei.business.entity.Party;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mq/send")
@Api(tags="mq发送消息")
@Slf4j
public class MqSendMsgController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     */
    @GetMapping("/sendMsg")
    public void sendMsg(){
        /*String exchange, String routingKey, Object message, MessagePostProcessor messagePostProcessor*/
        /** @param exchange the name of the exchange
         * @param routingKey the routing key
         * @param message a message to send
         * @param messagePostProcessor a processor to apply to the message before it is sent*/

        Party party = new Party();
        party.setPartyName("哈哈党");
        party.setLeaderName("哈哈");
        rabbitTemplate.convertAndSend("first.exchange","one.hello.queue","RR");
    }
}
