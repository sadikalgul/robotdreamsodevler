package com.robotdreams.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RateDto {
    private String target;
    private double rate;
}
