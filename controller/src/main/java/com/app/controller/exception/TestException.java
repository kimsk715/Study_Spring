package com.app.controller.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestException extends RuntimeException {
    public TestException(String message) {
        super(message);
    }
}
