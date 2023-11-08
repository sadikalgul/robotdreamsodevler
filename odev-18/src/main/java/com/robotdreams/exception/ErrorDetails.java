package com.robotdreams.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorDetails extends RuntimeException{


  public ErrorDetails(String message) {
    super(message);
  }
}
