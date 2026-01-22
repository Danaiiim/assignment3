package edu.aitu.oop.exceptions;

public class MenuItemNotAvailableException extends RuntimeException {
    public MenuItemNotAvailableException(String message) {
        super(message);
    }
}