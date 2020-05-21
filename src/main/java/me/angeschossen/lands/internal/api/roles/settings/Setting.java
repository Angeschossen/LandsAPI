package me.angeschossen.lands.internal.api.roles.settings;

public interface Setting {
    int getId();

    String getBypassPermission();

    SettingType getType();

    String getTogglePermission();

    String getMessageKey();
}
