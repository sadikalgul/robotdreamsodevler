package com.robotdreams.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConversionRequestDTO {

    private String source;
    private String target;
    private double amount;
}
