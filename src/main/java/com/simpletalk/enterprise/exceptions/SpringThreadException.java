package com.simpletalk.enterprise.exceptions;

public class SpringThreadException extends RuntimeException {
    public SpringThreadException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringThreadException(String exMessage) {
        super(exMessage);
    }
}
