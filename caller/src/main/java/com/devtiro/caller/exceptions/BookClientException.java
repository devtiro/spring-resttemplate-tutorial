package com.devtiro.caller.exceptions;

public class BookClientException extends RuntimeException {

    public BookClientException() {
    }

    public BookClientException(String message) {
        super(message);
    }

    public BookClientException(Throwable cause) {
        super(cause);
    }

    public BookClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
