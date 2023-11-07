package com.robotdreams.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CurrencySubModelDTO {
    private String source;
    private List<RateDto> rates = new ArrayList<>();
}
