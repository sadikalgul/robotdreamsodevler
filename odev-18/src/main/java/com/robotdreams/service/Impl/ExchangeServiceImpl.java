package com.robotdreams.service.Impl;

import com.robotdreams.model.ExchangeEntity;
import com.robotdreams.model.dto.ExchangeResponseDTO;
import com.robotdreams.repository.ExchangeRepository;
import com.robotdreams.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;
    @Override
    @Transactional
    public ExchangeResponseDTO findExchangeEntityBySourceAndTarget(String source, String target) {
        ExchangeEntity exchangeEntity = exchangeRepository.findExchangeEntityBySourceAndTarget(source, target);

        return ExchangeResponseDTO.builder()
                .rate(exchangeEntity.getRate())
                .build();
    }
}
