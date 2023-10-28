package com.robotdreams.notificationservice.repository;

import com.robotdreams.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationEntityRepository extends JpaRepository<Notification,Integer> {
}
