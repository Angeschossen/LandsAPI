package me.angeschossen.lands.api.exceptions;

public class NameAlreadyTakenException extends RuntimeException {

    public NameAlreadyTakenException(String errorMessage) {
        super(errorMessage);
    }
}
