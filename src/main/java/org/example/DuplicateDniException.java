package org.example;

public class DuplicateDniException extends Exception {
    public DuplicateDniException(String message) {
        super(message);
    }
}