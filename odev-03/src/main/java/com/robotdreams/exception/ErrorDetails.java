package com.robotdreams.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorDetails extends RuntimeException{


  public ErrorDetails(String message) {
    super(message);
  }
}
