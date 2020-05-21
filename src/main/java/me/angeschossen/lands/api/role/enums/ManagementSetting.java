package me.angeschossen.lands.api.role.enums;


import me.angeschossen.lands.internal.api.roles.settings.SettingType;

public enum ManagementSetting implements me.angeschossen.lands.internal.api.roles.settings.ManagementSetting {

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


    @Override
    public int getId() {
        return 0;
    }

    public String getBypassPermission() {
        return null;
    }

    @Override
    public SettingType getType() {
        return null;
    }

    @Override
    public String getTogglePermission() {
        return null;
    }

    @Override
    public String getMessageKey() {
        return null;
    }

}
