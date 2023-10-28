package com.robotdreams.notificationservice.rabbitMQ;


import com.robotdreams.client.notification.NotificationRequest;
import com.robotdreams.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest request) {
        log.info("Notification request is consumed from rabbitmq : " + request);
        notificationService.sendNotification(request);
    }

}
