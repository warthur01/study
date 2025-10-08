package com.contacts;

public class Validator {
    private static final String REGEX_EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final String REGEX_NUMBER = "^(1[1-9]|2[12478]|3([1-5]|[7-8])|4[1-9]|5(1|[3-5])|6[1-9]|7[134579]|8[1-9]|9[1-9])9[0-9]{8}$";
            //"^[\\d\\p{P}]$";

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
