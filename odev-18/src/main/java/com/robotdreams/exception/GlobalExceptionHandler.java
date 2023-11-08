package com.robotdreams.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ErrorDetails.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorEntity> resourceNotFoundException(ErrorDetails exception, WebRequest webRequest){
        ErrorEntity errorEntity = new ErrorEntity(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<ErrorEntity>(errorEntity, HttpStatus.NOT_FOUND);
    }


}
