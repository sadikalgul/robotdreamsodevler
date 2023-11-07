package com.robotdreams.loader;

import com.robotdreams.model.dto.CurrencyModelDTO;
import com.robotdreams.model.dto.CurrencySubModelDTO;
import com.robotdreams.model.dto.RateDto;
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

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        //CurrencyModelDTO currencyModelDTOS = new CurrencyModelDTO();
        CurrencyModelDTO currencySubModelDTOS = restTemplate.getForObject("https://mocki.io/v1/1e26abb9-d48e-42b9-995d-54cddecfbae2",CurrencyModelDTO.class);
        System.out.println("data retrieved");
        for(CurrencySubModelDTO currencySubModelDTO : currencySubModelDTOS.getCurrencySubModelDTOList()){
            for (RateDto rateDto : currencySubModelDTO.getRateDtoList()){
                System.out.println(currencySubModelDTO.getSource() + rateDto.getRate() + rateDto.getTarget());
            }
        }
    }
}
