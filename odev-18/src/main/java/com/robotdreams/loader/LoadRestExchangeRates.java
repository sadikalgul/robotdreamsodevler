package com.robotdreams.loader;

import com.robotdreams.model.ExchangeEntity;
import com.robotdreams.model.dto.CurrencyModelDTO;
import com.robotdreams.model.dto.CurrencySubModelDTO;
import com.robotdreams.model.dto.RateDto;
import com.robotdreams.repository.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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
                ExchangeEntity exchange = ExchangeEntity.builder()
                        .source(currencySubModelDTO.getSource())
                        .target(rateDto.getTarget())
                        .rate(rateDto.getRate())
                        .build();
                exchangeRepository.save(exchange);
            }
        }
       // ExchangeEntity exchange = exchangeRepository.findExchangeEntityBySourceAndTarget("TRY","USD");
       // System.out.println("rate:" + exchange.getRate());
    }
}
