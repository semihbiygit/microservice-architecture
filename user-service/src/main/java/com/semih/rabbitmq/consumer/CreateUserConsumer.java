package com.semih.rabbitmq.consumer;

import com.semih.rabbitmq.model.CreateUser;
import com.semih.repository.entity.UserProfile;
import com.semih.services.UserProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreateUserConsumer {
    private final UserProfileService userProfileService;

    @RabbitListener(queues = "queue-auth-create-user")
    public void createUserMessageConsumer(CreateUser user) {
        log.info("User received: {}", user.toString());
        userProfileService.save(UserProfile.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .authId(user.getAuthId())
                .build());
    }

}
