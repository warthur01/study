package com.contacts;

public class InvalidNumberException extends Exception {
    public InvalidNumberException(String message) {
        super(message);
    }

    public InvalidNumberException() {

    }

    public InvalidNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumberException(Throwable cause) {
        super(cause);
    }

    public InvalidNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
