package me.angeschossen.lands.api.land.enums;

import me.angeschossen.lands.Lands;
import me.angeschossen.lands.configuration.Config;

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

    public static void init() {
        try {
            for (LandSetting landSetting : values()) {
                landSetting.allowInWar = Config.getBoolean("chunk.setting." + landSetting.toString() + ".during-war");
            }
        } catch (Throwable e) {
            Lands.logger.warning("Failed to init LandSettings enum.");
            e.printStackTrace();
        }
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
