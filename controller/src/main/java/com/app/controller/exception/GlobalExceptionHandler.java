package com.app.controller.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.app.controller.ex")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(TestException.class)
    protected String handleTestException(TestException e){
        log.error(e.getMessage());
        return "test";
    }
}
