package com.contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String REGEX_EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static boolean emailValidator (String email) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String validEmail = "arthurdsteixeira@gmail.com";
        System.out.println("Valid email: " + validEmail + " - " + emailValidator(validEmail));

    }
}
