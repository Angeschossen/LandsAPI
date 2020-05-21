package me.angeschossen.lands.api.land.enums;


public enum LandType {
    PLAYER(0), SAFEZONE(1);

    public final int id;

    LandType(int id) {
        this.id = id;
    }

    public static LandType getByID(int iD) {
        for (LandType landType : values()) {
            if (landType.id == iD)
                return landType;
        }

        return LandType.PLAYER;
    }
}
