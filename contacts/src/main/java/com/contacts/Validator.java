package com.contacts;

public class Validator {
    private static final String REGEX_EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String REGEX_NUMBER = "[\\d\\p{P}]";

    public static boolean emailValidator(String email) throws InvalidEmail {
        if (!email.matches(REGEX_EMAIL)) {
            throw new InvalidEmail("");
        }
        return true;
    }

    public static boolean phoneValidator(String number) throws InvalidNumber {
        if (!number.matches(REGEX_NUMBER)) {
            throw new InvalidNumber("");
        }
        return true;
    }
}
