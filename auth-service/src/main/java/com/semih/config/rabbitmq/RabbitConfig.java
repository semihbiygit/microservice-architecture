package com.semih.config.rabbitmq;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    private String exchangeNameAuth = "exchange-auth";
    private String bindingKeyAuth = "key-auth";
    private String queueNameAuth = "queue-auth-create-user";

    @Bean
    DirectExchange exchangeAuth() {
        return new DirectExchange(exchangeNameAuth);
    }

    @Bean
    Queue queueCreateUser() {
        return new Queue(queueNameAuth);
    }

    @Bean
    public Binding bindingCreateUser(final Queue queueCreateUser, final DirectExchange exchangeAuth) {
        return BindingBuilder.bind(queueCreateUser).to(exchangeAuth).with(bindingKeyAuth);
    }
}
