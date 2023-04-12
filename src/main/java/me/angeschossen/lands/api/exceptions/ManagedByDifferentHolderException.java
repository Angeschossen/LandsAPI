package me.angeschossen.lands.api.exceptions;

public class ManagedByDifferentHolderException extends RuntimeException {
    public ManagedByDifferentHolderException(String errorMessage) {
        super(errorMessage);
    }
}
