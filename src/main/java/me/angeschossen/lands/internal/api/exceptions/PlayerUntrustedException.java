package me.angeschossen.lands.internal.api.exceptions;

public class PlayerUntrustedException extends RuntimeException {
    public PlayerUntrustedException(String errorMessage) {
        super(errorMessage);
    }

}
