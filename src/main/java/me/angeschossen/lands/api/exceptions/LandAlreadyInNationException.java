package me.angeschossen.lands.api.exceptions;

import me.angeschossen.lands.api.land.Land;

public class LandAlreadyInNationException extends RuntimeException {


    public LandAlreadyInNationException(Land land) {
        super("This land is already part of a nation. Land: " + land.toString());
    }


}
