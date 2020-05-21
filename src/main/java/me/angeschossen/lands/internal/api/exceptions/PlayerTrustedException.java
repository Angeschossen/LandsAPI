package me.angeschossen.lands.internal.api.exceptions;

public class PlayerTrustedException extends RuntimeException {
    public PlayerTrustedException(String errorMessage) {
        super(errorMessage);
    }
}
