package com.gamerent;

public class Validator {
    private static final String REGEX_EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static boolean emailValidator(String email) throws InvalidEmailException {
        if (!email.matches(REGEX_EMAIL)) {
            throw new InvalidEmailException("Client not saved.Invalid email: " + email);
        }
        return true;
    }
}
