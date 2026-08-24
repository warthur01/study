package com.agenda.agenda.validation;

public class Validator {
    private static final String REGEX_EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String REGEX_NUMBER = "^\\d{11}$";
    public static boolean emailValidator(String email) throws InvalidEmailException {
        if (!email.matches(REGEX_EMAIL)) {
            throw new InvalidEmailException("Contact not saved.Invalid email: " + email);
        }
        return true;
    }

    public static boolean phoneValidator(String number) throws InvalidNumberException {
        if (!number.matches(REGEX_NUMBER)) {
            throw new InvalidNumberException("Contact not saved.Invalid number: " + number);
        }
        return true;
    }
}
