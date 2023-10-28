package com.robotdreams.notificationservice.service;

import com.robotdreams.client.notification.NotificationRequest;
import com.robotdreams.notificationservice.model.Notification;
import com.robotdreams.notificationservice.repository.NotificationEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    private final NotificationEntityRepository notificationEntityRepository;

    public void sendNotification(NotificationRequest notificationRequest){

        notificationEntityRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerPhone(notificationRequest.getToCustomerPhone())
                        .message(notificationRequest.getMessage())
                        .sender("Sadik Algul")
                        .sentAt(LocalDateTime.now())
                        .build()
        );

        log.info("Notification sent :   {}" ,notificationRequest.getMessage());
    }
}
