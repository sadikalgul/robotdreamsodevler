package com.robotdreams.controller;

import com.robotdreams.model.dto.ExchangeResponseDTO;
import com.robotdreams.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

    private  final ExchangeService exchangeService;

    @GetMapping("/exchange-rate")
    public ExchangeResponseDTO getExchangeRate(
            @RequestParam("source") String source,
            @RequestParam("target") String target){
        return exchangeService.findExchangeEntityBySourceAndTarget(source, target);
    }


}
