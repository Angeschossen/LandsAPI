package me.angeschossen.lands.api.land.enums;

/**
 * Use {@link me.angeschossen.lands.api.flags.type.Flags} instead.
 */
@Deprecated
public enum LandSetting {
    ENTITY_GRIEFING(0, "ENTITY_GRIEFING", true, false, true),
    TNT_GRIEFING(1, "TNT_GRIEFING", true, false, true),
    PISTON_GRIEFING(2, "PISTON_GRIEFING", true, false, true),
    MONSTER_SPAWN(3, "MONSTER_SPAWN", true, false, true),
    ANIMAL_SPAWN(4, "ANIMAL_SPAWN", true, false, true),
    WATERFLOW_ALLOW(5, "WATERFLOW_ALLOW", true, false, true),
    TITLE_HIDE(6, "TITLE_HIDE", true, false, false),
    FIRE_SPREAD(7, "FIRE_SPREAD", true, false, true),
    LEAF_DECAY(8, "LEAF_DECAY", true, false, true),
    PLANT_GROWTH(9, "PLANT_GROWTH", true, false, true),
    SNOW_KEEP(10, "SNOW_MELT", true, false, true, true);

    private final int iD;
    private final boolean isWilderness;
    private final boolean displayable, forceEnable;
    private final boolean isInverted;
    private final String cfgName;
    private boolean allowInWar;

    LandSetting(int iD, String cfgName, boolean displayable, boolean forceEnable, boolean isWilderness) {
        this(iD, cfgName, displayable, forceEnable, isWilderness, false);
    }

    LandSetting(int iD, String cfgName, boolean displayable, boolean forceEnable, boolean isWilderness, boolean isInverted) {
        this.iD = iD;
        this.cfgName = cfgName;
        this.displayable = displayable;
        this.forceEnable = forceEnable;
        this.isWilderness = isWilderness;
        this.isInverted = isInverted;
    }

    public boolean isInverted() {
        return isInverted;
    }

    public String getCfgName() {
        return cfgName;
    }

    public static LandSetting getById(int iD) {
        for (LandSetting setting : values()) {
            if (setting.getId() == iD)
                return setting;
        }

        throw new IllegalArgumentException("No LandSetting with iD '" + iD + "' found.");
    }

    public static LandSetting getByCfgName(String name) {
        for (LandSetting setting : values()) {
            if (setting.cfgName.equals(name))
                return setting;
        }

        throw new IllegalArgumentException("No LandSetting with name '" + name + "' found.");
    }

    public static void init() {

    }

    public boolean getStatus(boolean b) {
        return isInverted != b;
    }

    public int getId() {
        return iD;
    }

    public boolean isWilderness() {
        return isWilderness;
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
