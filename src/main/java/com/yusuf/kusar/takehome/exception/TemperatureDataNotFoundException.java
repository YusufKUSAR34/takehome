package com.yusuf.kusar.takehome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FOUND)
public class TemperatureDataNotFoundException extends RuntimeException{
    public TemperatureDataNotFoundException(String message) {
        super(message);
    }
}
