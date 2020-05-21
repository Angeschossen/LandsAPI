package me.angeschossen.lands.api.nation;



public enum NationManagementSetting {
    WAR_MANAGE, TAXES_EDIT, LAND_TRUST, LAND_UNTRUST, BANK_WITHDRAW, DELETE;


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
