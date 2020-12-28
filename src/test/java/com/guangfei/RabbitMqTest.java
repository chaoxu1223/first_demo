package com.guangfei;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.amqp.core.Binding.DestinationType.QUEUE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 创建一个交换机
     */
    @Test
   public void createExchange(){
        /*String name, boolean durable, boolean autoDelete, Map<String, Object> arguments*/
        Exchange exchange = new TopicExchange("first.exchange",true,false,null);
        amqpAdmin.declareExchange(exchange);
   }

    /**
     * 创建第一个队列
     */
    @Test
    public void createQueue(){
        /*String name, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments*/
        Queue queue = new Queue("one.queue",true,false,false,null);
        amqpAdmin.declareQueue(queue);
    }

    /**
     * 创建第二个队列
     */
    @Test
    public void createQueue2(){
        /*String name, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments*/

        Queue queue = new Queue("one.two.queue",true,false,false,null);
        amqpAdmin.declareQueue(queue);
    }

    /**
     * 交换机绑定队列
     */
    @Test
    public void bindExchangeAndQueue(){
        /*String destination, Binding.DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments*/
        Binding binding1 = new Binding("one.queue",QUEUE,"first.exchange","one.queue",null);
        Binding binding2 = new Binding("one.two.queue",QUEUE,"first.exchange","one.two.queue",null);

        amqpAdmin.declareBinding(binding1);
        amqpAdmin.declareBinding(binding2);
    }

    /**
     * 发送消息
     */
    @Test
    public void sendMsg(){

        /*String exchange, String routingKey, Object message, MessagePostProcessor messagePostProcessor*/

        /** @param exchange the name of the exchange
           * @param routingKey the routing key
           * @param message a message to send
	       * @param messagePostProcessor a processor to apply to the message before it is sent*/
        rabbitTemplate.convertAndSend("first.exchange","one.queue","love");
    }

}
