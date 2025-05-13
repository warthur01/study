package com.contacts;

public class InvalidEmail extends Exception {
    public InvalidEmail(String message) {
        super(message);
    }

    public InvalidEmail(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEmail(Throwable cause) {
        super(cause);
    }

    public InvalidEmail(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidEmail() {
    }

}
