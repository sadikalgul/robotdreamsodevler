package com.robotdreams.loader;

import com.robotdreams.model.Exchange;
import com.robotdreams.model.dto.CurrencyModelDTO;
import com.robotdreams.model.dto.CurrencySubModelDTO;
import com.robotdreams.model.dto.RateDto;
import com.robotdreams.repository.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LoadRestExchangeRates implements ApplicationRunner {

    private final RestTemplate restTemplate;
    private final ExchangeRepository exchangeRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        CurrencyModelDTO currencySubModelDTOS = restTemplate.getForObject("https://mocki.io/v1/1e26abb9-d48e-42b9-995d-54cddecfbae2",CurrencyModelDTO.class);
        for(CurrencySubModelDTO currencySubModelDTO : currencySubModelDTOS.getCurrencies()){
            for (RateDto rateDto : currencySubModelDTO.getRates()){
                Exchange exchange = Exchange.builder()
                        .source(currencySubModelDTO.getSource())
                        .target(rateDto.getTarget())
                        .rate(rateDto.getRate())
                        .build();
                exchangeRepository.save(exchange);
            }
        }
    }
}
