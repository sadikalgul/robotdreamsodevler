package com.robotdreams.model.dto;

import lombok.*;

@Data
@Builder
public class ConversionResponseDTO {
    private String target;
    private double amount;
    private String transactionId;
}
