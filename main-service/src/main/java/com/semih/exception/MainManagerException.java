package com.semih.exception;

import lombok.Getter;

@Getter
public class MainManagerException extends RuntimeException {
    private final ErrorType errorType;

    public MainManagerException(ErrorType errorType) {
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public MainManagerException(ErrorType errorType, String customMessage) {
        super(customMessage);
        this.errorType = errorType;
    }

}
