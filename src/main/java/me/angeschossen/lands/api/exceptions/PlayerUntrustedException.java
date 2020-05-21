package me.angeschossen.lands.api.exceptions;

public class PlayerUntrustedException extends RuntimeException {
    public PlayerUntrustedException(String errorMessage) {
        super(errorMessage);
    }

}
