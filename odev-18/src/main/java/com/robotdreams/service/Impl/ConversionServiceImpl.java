package com.robotdreams.service.Impl;

import com.robotdreams.model.ConversionEntity;
import com.robotdreams.model.ExchangeEntity;
import com.robotdreams.model.dto.ConversionRequestDTO;
import com.robotdreams.model.dto.ConversionResponseDTO;
import com.robotdreams.repository.ConversionRepository;
import com.robotdreams.repository.ExchangeRepository;
import com.robotdreams.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConversionServiceImpl implements ConversionService {

    private final ExchangeRepository exchangeRepository;
    private final ConversionRepository conversionRepository;
    @Override
    @Transactional
    public ConversionResponseDTO convertCurrenciesAndSave(ConversionRequestDTO conversionRequestDTO) {

        ExchangeEntity exchangeEntity = exchangeRepository.findExchangeEntityBySourceAndTarget(conversionRequestDTO.getSource(), conversionRequestDTO.getTarget());

        double calculatedAmount = conversionRequestDTO.getAmount() * exchangeEntity.getRate();
        ConversionEntity conversionEntity = ConversionEntity.builder()
                .amount(conversionRequestDTO.getAmount())
                .calculatedAmount(calculatedAmount)
                .transactionId(UUID.randomUUID().toString())
                .transactionDate(LocalDateTime.now())
                .exchange(exchangeEntity)
                .build();

        conversionEntity = conversionRepository.save(conversionEntity);

        return ConversionResponseDTO.builder()
                .amount(calculatedAmount)
                .target(conversionRequestDTO.getTarget())
                .transactionId(conversionEntity.getTransactionId())
                .build();
    }

    @Override
    @Transactional
    public ConversionResponseDTO getConversionListByTransactionId(String transactionId) {

        ConversionEntity conversionEntity = conversionRepository.findByTransactionId(transactionId);

        return ConversionResponseDTO.builder()
                .amount(conversionEntity.getAmount())
                .transactionId(conversionEntity.getTransactionId())
                .target(conversionEntity.getExchange().getTarget())
                .build();
    }
}
