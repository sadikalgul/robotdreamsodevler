package com.robotdreams.schoolmanage.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
public class ErrorEntity {
    Date exceptionDate;
    String message;
    String webMessage;
}
