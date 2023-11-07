package com.robotdreams.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CurrencyModelDTO {
    private List<CurrencySubModelDTO> currencies = new ArrayList<>();
}
