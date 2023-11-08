package com.robotdreams.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class ConversionResponseDTO {
    private String source;
    private String target;
    private double amount;
    private double calculatedAmount;
    private String transactionId;
    private LocalDateTime transactionDate;
}
