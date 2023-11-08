package com.robotdreams.service;

import com.robotdreams.model.dto.ConversionRequestDTO;
import com.robotdreams.model.dto.ConversionResponseDTO;

import java.util.List;

public interface ConversionService {
    ConversionResponseDTO convertCurrenciesAndSave(ConversionRequestDTO conversionRequestDTO);
    ConversionResponseDTO getConversionListByTransactionId (String transactionId);
}
