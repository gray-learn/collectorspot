package com.collector.imageservice.config;

import jakarta.annotation.Resource;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class MessagingConfig implements InitializingBean {

    public static final String QUEUE = "collector_queue";
    public static final String EXCHANGE = "collector_exchange";
    public static final String ROUTING_KEY = "collector_routingKey";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    // JSON Convert
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void afterPropertiesSet() {
        // Serialize the JSON
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    }
    // JSON Convert

//    @Bean Cycle Refer
//    public MessageConverter converter() {
//        return new Jackson2JsonMessageConverter();
//    }
}