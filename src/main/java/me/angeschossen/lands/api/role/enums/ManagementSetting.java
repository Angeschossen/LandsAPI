package me.angeschossen.lands.api.role.enums;

import me.angeschossen.lands.api.land.enums.SettingType;

public enum ManagementSetting implements SettingRole {

    PLAYER_TRUST(1, "", true, SettingType.MIXED),
    PLAYER_UNTRUST(2, "", true, SettingType.MIXED),
    PLAYER_SETROLE(3, "", true, SettingType.MIXED),
    LAND_CLAIM(4, "", true, SettingType.GLOBAL),
    LAND_CLAIM_BORDER(5, "", true, SettingType.GLOBAL),
    SPAWN_SET(6, "", true, SettingType.GLOBAL),
    SPAWN_TELEPORT(7, "", false, SettingType.GLOBAL),
    LAND_RENAME(8, "", true, SettingType.GLOBAL),
    SETTING_EDIT_LAND(9, "", true, SettingType.MIXED),
    SETTING_EDIT_ROLE(10, "", true, SettingType.MIXED),
    SETTING_EDIT_ADVANCED(11, "", true, SettingType.MIXED),
    SETTING_EDIT_TAXES(12, "", true, SettingType.MIXED),
    SETTING_EDIT_VARIOUS(13, "", true, SettingType.MIXED),
    BALANCE_WITHDRAW(14, "", true, SettingType.MIXED),
    CHUNK_ASSIGN(15, "", true, SettingType.GLOBAL);


    public String iD;
    private final int id;
    public String message;
    private String bypassPermission;
    private SettingType settingType;

    ManagementSetting(int id, String message, boolean isAdmin, SettingType settingType) {
        this.iD = name().toLowerCase();
        this.id = id;
        this.settingType = settingType;
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

    public SettingType getSettingType() {
        return settingType;
    }


    @Override
    public String getBypassPermission() {
        return bypassPermission;
    }

    @Override
    public me.angeschossen.lands.api.role.enums.SettingType getType() {
        return me.angeschossen.lands.api.role.enums.SettingType.MANAGEMENT;
    }
}
