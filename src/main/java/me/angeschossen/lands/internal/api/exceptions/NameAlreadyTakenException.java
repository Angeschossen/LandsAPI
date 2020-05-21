package me.angeschossen.lands.internal.api.exceptions;

public class NameAlreadyTakenException extends RuntimeException {

    public NameAlreadyTakenException(String errorMessage) {
        super(errorMessage);
    }
}
