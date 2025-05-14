package com.contacts;

public class Validator {
    private static final String REGEX_EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String REGEX_NUMBER = "[\\d\\p{P}]";

    public static boolean emailValidator(String email) throws InvalidEmailException {
        if (!email.matches(REGEX_EMAIL)) {
            throw new InvalidEmailException("");
        }
        return true;
    }

    public static boolean phoneValidator(String number) throws InvalidNumberException {
        if (!number.matches(REGEX_NUMBER)) {
            throw new InvalidNumberException("");
        }
        return true;
    }
}
