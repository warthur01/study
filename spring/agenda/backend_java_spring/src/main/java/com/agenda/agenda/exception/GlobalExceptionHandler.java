package com.agenda.agenda.exception;

import com.agenda.agenda.validation.InvalidEmailException;
import com.agenda.agenda.validation.InvalidNumberException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidEmail(InvalidEmailException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidNumberException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidNumber(InvalidNumberException ex) {
        return ex.getMessage();
    }
}