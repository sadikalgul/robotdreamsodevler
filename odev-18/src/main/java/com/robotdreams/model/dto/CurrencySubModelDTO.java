package com.robotdreams.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class CurrencySubModelDTO {
    private String source;
    private List<RateDto> rateDtoList = new ArrayList<>();
}
