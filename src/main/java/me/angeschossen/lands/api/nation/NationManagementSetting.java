package me.angeschossen.lands.api.nation;


public enum NationManagementSetting {
    WAR_MANAGE(0), TAXES_EDIT(2), LAND_TRUST(3), LAND_UNTRUST(4), BANK_WITHDRAW(5), DELETE(6);

    private final int id;
    private final String byPassPermission;

    NationManagementSetting(int id) {
        this.id = id;
        this.byPassPermission = "nations.bypass." + toString().toLowerCase();
    }


    public String getBypassPermission() {
        return byPassPermission;
    }


    public String getTogglePermission() {
        return "nations.role.setting." + toString();
    }

    public String getMessageKey() {
        return "nations.noaccess.action";
    }
}
