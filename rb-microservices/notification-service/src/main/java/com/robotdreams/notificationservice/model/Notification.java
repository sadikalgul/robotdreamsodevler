package com.robotdreams.notificationservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "notification")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long toCustomerId;
    private String toCustomerPhone;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}
