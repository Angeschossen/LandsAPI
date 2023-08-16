package me.angeschossen.lands.api.exceptions;

import me.angeschossen.lands.api.land.Land;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * Thrown if a land is part of a nation and you try to add it to another nation.
 */
public class LandAlreadyInNationException extends RuntimeException {

    /**
     * Create instance.
     */
    public LandAlreadyInNationException() {
        super("This land is already part of a nation.");
    }
}
