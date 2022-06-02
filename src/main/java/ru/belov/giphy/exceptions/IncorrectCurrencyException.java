package ru.belov.giphy.exceptions;

public class IncorrectCurrencyException extends RuntimeException {

    public IncorrectCurrencyException(String message, Throwable err) {
        super(message, err);
    }

    public IncorrectCurrencyException(String message) {
        super(message);
    }

}
