package org.example;

public class NoAvailableKitsException extends Exception {
    public NoAvailableKitsException(String message) {
        super(message);
    }
}