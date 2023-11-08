package com.robotdreams.service;

import com.robotdreams.model.dto.ExchangeResponseDTO;
import org.springframework.stereotype.Service;

public interface ExchangeService {

    ExchangeResponseDTO findExchangeEntityBySourceAndTarget(String source,String target);
}
