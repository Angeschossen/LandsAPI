package me.angeschossen.lands.api.role.enums;

import me.angeschossen.lands.api.land.enums.SettingMode;
import me.bytesoft.pluginapi.api.roles.settings.SettingType;

public enum ManagementSetting implements me.bytesoft.pluginapi.api.roles.settings.ManagementSetting {

    PLAYER_TRUST(1, "", true, SettingMode.MIXED),
    PLAYER_UNTRUST(2, "", true, SettingMode.MIXED),
    PLAYER_SETROLE(3, "", true, SettingMode.MIXED),
    LAND_CLAIM(4, "", true, SettingMode.GLOBAL),
    LAND_CLAIM_BORDER(5, "", true, SettingMode.GLOBAL),
    SPAWN_SET(6, "", true, SettingMode.GLOBAL),
    LAND_RENAME(8, "", true, SettingMode.GLOBAL),
    SETTING_EDIT_LAND(9, "", true, SettingMode.MIXED),
    SETTING_EDIT_ROLE(10, "", true, SettingMode.MIXED),
    SETTING_EDIT_TAXES(12, "", true, SettingMode.MIXED),
    SETTING_EDIT_VARIOUS(13, "", true, SettingMode.MIXED),
    BALANCE_WITHDRAW(14, "", true, SettingMode.MIXED),
    AREA_ASSIGN(15, "", true, SettingMode.GLOBAL),
    PLAYER_BAN(16, "", true, SettingMode.MIXED),
    WAR_MANAGE(17, "", true, SettingMode.GLOBAL);

    private final int id;
    public String iD;
    public String message;
    private String bypassPermission;
    private SettingMode settingMode;

    ManagementSetting(int id, String message, boolean isAdmin, SettingMode settingMode) {
        this.iD = name().toLowerCase();
        this.id = id;
        this.settingMode = settingMode;
        this.message = message;

        if (!isAdmin)
            this.bypassPermission = "lands.bypass." + iD;
        else this.bypassPermission = "lands.admin." + iD;

    }


    public static ManagementSetting getById(String iD) {
        for (ManagementSetting action : values()) {
            if (action.iD.equals(iD))
                return action;
        }

        throw new IllegalArgumentException("No ManagementSetting with iD '" + iD + "' found.");
    }

    public static ManagementSetting getById(int iD) {
        for (ManagementSetting action : values()) {
            if (action.getId() == iD)
                return action;
        }

        throw new IllegalArgumentException("No ManagementSetting with iD '" + iD + "' found.");
    }

    @Override
    public String toString() {
        return iD;
    }

    public int getId() {
        return id;
    }

    public SettingMode getSettingMode() {
        return settingMode;
    }


    @Override
    public String getBypassPermission() {
        return bypassPermission;
    }

    @Override
    public SettingType getType() {
        return SettingType.MANAGEMENT;
    }

    @Override
    public String getTogglePermission() {
        return "lands.role.setting." + toString();
    }

    @Override
    public String getMessageKey() {
        return message;
    }

}
