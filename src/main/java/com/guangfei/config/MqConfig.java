package com.guangfei.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MqConfig {

    /**
     * 创建一个普通Topic交换机
     */
    @Bean
    public Exchange createCommonTopicExchange(){
        /*String name, boolean durable, boolean autoDelete, Map<String, Object> arguments*/
        Exchange exchange = new TopicExchange("first.exchange",true,false,null);
        return exchange;
    }

    /**
     * 创建一个普通队列
     */
    @Bean
    public Queue createCommonQueue(){
        /*String name, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments*/
        Queue queue = new Queue("one.common.queue",true,false,false,null);
        return queue;
    }

    /**
     * 创建一个绑定到死信交换机的队列
     */
    @Bean
    public Queue createTtlQueue(){
        /*String name, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments*/
        Queue queue = new Queue("one.ttl.queue",true,false,false,null);
        return queue;
    }

    /**
     * 创建一个延时队列
     */
    @Bean
    public Queue createDelayQueue(){
        /*String name, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments*/

        Map<String,Object> args = new HashMap<String,Object>();
        args.put("x-dead-letter-exchange","first.exchange");
        args.put("x-dead-letter-routing-key","one.ttl.queue");
        args.put("x-message-ttl",30000);
        Queue queue = new Queue("one.delay.queue",true,false,false,args);
        return queue;
    }

    @Bean
    public Binding bindDelayQueue(){
        /*String destination, Binding.DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments*/
        Binding binding = new Binding("one.delay.queue",Binding.DestinationType.QUEUE,"first.exchange","one.*.queue",null);
        return binding;
    }

    @Bean
    public Binding bindCommonQueue(){
        /*String destination, Binding.DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments*/
        Binding binding = new Binding("one.common.queue",Binding.DestinationType.QUEUE,"first.exchange","one.common.queue",null);
        return binding;
    }


    @Bean
    public Binding bindTtlQueue(){
        /*String destination, Binding.DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments*/
        Binding binding = new Binding("one.ttl.queue",Binding.DestinationType.QUEUE,"first.exchange","one.ttl.queue",null);

        return binding;
    }
}
