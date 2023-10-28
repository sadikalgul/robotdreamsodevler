package com.robotdreams.notificationservice.controller;

import com.robotdreams.client.notification.NotificationRequest;
import com.robotdreams.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping("/notifications")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest){
        notificationService.sendNotification(notificationRequest);
        log.info("notifications sent...");
    }

}
