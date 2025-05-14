package com.contacts;

public class InvalidNumber extends Exception {
    public InvalidNumber(String message) {
        super(message);
    }

    public InvalidNumber() {

    }

    public InvalidNumber(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNumber(Throwable cause) {
        super(cause);
    }

    public InvalidNumber(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
