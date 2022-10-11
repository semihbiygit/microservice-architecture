package com.semih.rabbitmq.producer;

import com.semih.rabbitmq.model.CreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserProducer {

    /**
     * We use rabbit template to send message.
     */
    private final RabbitTemplate rabbitTemplate;

    public void sendCreateUserMessage(CreateUser user) {
        rabbitTemplate.convertAndSend("exchange-auth","key-auth",user);
    }
}
