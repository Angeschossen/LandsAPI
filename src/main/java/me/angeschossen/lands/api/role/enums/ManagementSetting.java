package me.angeschossen.lands.api.role.enums;


public enum ManagementSetting {

    PLAYER_TRUST,
    PLAYER_UNTRUST,
    PLAYER_SETROLE,
    LAND_CLAIM,
    LAND_CLAIM_BORDER,
    SPAWN_SET,
    LAND_RENAME,
    SETTING_EDIT_LAND,
    SETTING_EDIT_ROLE,
    SETTING_EDIT_TAXES,
    SETTING_EDIT_VARIOUS,
    BALANCE_WITHDRAW,
    AREA_ASSIGN,
    PLAYER_BAN,
    WAR_MANAGE;

    public String getBypassPermission() {
        return null;
    }

    public String getTogglePermission() {
        return null;
    }


    public String getMessageKey() {
        return null;
    }

}
