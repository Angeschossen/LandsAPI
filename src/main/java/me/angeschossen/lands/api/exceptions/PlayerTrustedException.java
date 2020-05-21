package me.angeschossen.lands.api.exceptions;

public class PlayerTrustedException extends RuntimeException {
    public PlayerTrustedException(String errorMessage) {
        super(errorMessage);
    }
}
