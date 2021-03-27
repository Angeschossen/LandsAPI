package me.angeschossen.lands.api.exceptions;

import me.angeschossen.lands.api.flags.Flag;

public class FlagConflictException extends RuntimeException {

    private final Flag existing;

    public FlagConflictException(Flag existing, String message) {
        super(message);

        this.existing = existing;
    }

    public Flag getExisting() {
        return existing;
    }
}
