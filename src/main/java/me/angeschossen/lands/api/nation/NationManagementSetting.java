package me.angeschossen.lands.api.nation;


import me.bytesoft.pluginapi.api.roles.settings.ManagementSetting;
import me.bytesoft.pluginapi.api.roles.settings.SettingType;

public enum NationManagementSetting implements ManagementSetting {
    WAR_MANAGE(0), TAXES_EDIT(2), LAND_TRUST(3), LAND_UNTRUST(4), BANK_WITHDRAW(5), DELETE(6);

    private final int id;
    private final String byPassPermission;

    NationManagementSetting(int id) {
        this.id = id;
        this.byPassPermission = "nations.bypass." + toString().toLowerCase();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getBypassPermission() {
        return byPassPermission;
    }

    @Override
    public SettingType getType() {
        return SettingType.MANAGEMENT;
    }

    @Override
    public String getTogglePermission() {
        return "nations.role.setting." + toString();
    }

    @Override
    public String getMessageKey() {
        return "nations.noaccess.action";
    }
}
