package me.angeschossen.lands.api.land.enums;

public enum LandSetting {
    ENTITY_GRIEFING(0),
    TNT_GRIEFING(1),
    PISTON_GRIEFING(2),
    MONSTER_SPAWN(3),
    ANIMAL_SPAWN(4),
    WATERFLOW_ALLOW(5);

    private int iD;

    LandSetting(int iD) {
        this.iD = iD;
    }

    public int getId() {
        return iD;
    }

    public static LandSetting getByID(int iD) {
        for (LandSetting setting : values()) {
            if (setting.getId() == iD)
                return setting;
        }

        throw new IllegalArgumentException("No LandSetting with iD '" + iD + "' found.");
    }
}
