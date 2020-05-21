package me.angeschossen.lands.api.land.enums;



public enum LandSetting {
    ENTITY_GRIEFING(0, true, false,true),
    TNT_GRIEFING(1, true, false,true),
    PISTON_GRIEFING(2, true, false,true),
    MONSTER_SPAWN(3, true, false,true),
    ANIMAL_SPAWN(4, true, false,true),
    WATERFLOW_ALLOW(5, true, false,true),
    TITLE_HIDE(6, false, false,false);

    private int iD;
    private boolean isWilderness;
    private boolean allowInWar;
    private final boolean displayable, forceEnable;

    LandSetting(int iD, boolean displayable, boolean forceEnable, boolean isWilderness) {
        this.iD = iD;
        this.displayable = displayable;
        this.forceEnable = forceEnable;
        this.isWilderness = isWilderness;
    }

    public int getId() {
        return iD;
    }

    public boolean isWilderness() {
        return isWilderness;
    }

    public static LandSetting getByID(int iD) {
        for (LandSetting setting : values()) {
            if (setting.getId() == iD)
                return setting;
        }

        throw new IllegalArgumentException("No LandSetting with iD '" + iD + "' found.");
    }

    public boolean isAllowInWar() {
        return allowInWar;
    }

    public boolean isDisplayable() {
        return displayable;
    }

    public boolean isForceEnable() {
        return forceEnable;
    }
}
