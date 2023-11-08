package com.robotdreams.controller;

import com.robotdreams.model.dto.ConversionRequestDTO;
import com.robotdreams.model.dto.ConversionResponseDTO;
import com.robotdreams.service.ConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ConversionController {

    private final ConversionService conversionService;


    @GetMapping("/conversion-list-id")
    ConversionResponseDTO getConversionListByTransactionId(@RequestParam("transactionId") String transactionId){

        return conversionService.getConversionListByTransactionId(transactionId);
    }

    @PostMapping(value = "/conversion")
    ConversionResponseDTO convertCurrenciesAndSave(@RequestBody ConversionRequestDTO conversionRequestDTO){

        return conversionService.convertCurrenciesAndSave(conversionRequestDTO);
    }
}
