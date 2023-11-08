package com.robotdreams.model.dto;


import lombok.*;

@Data
@Builder
public class ExchangeRequestDTO {

    private String source;
    private String target;

}
