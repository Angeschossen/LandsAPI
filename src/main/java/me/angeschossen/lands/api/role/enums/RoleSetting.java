package me.angeschossen.lands.api.role.enums;

import me.angeschossen.lands.internal.api.roles.settings.SettingType;

public enum RoleSetting implements me.angeschossen.lands.internal.api.roles.settings.RoleSetting {
    BLOCK_BREAK,
    BLOCK_PLACE,
    ATTACK_PLAYER,
    ATTACK_ANIMAL,
    BLOCK_IGNITE,
    INTERACT_GENERAL,
    INTERACT_MECHANISM,
    INTERACT_CONTAINER,
    INTERACT_DOOR,
    INTERACT_VILLAGER,
    FLY,
    SPAWN_TELEPORT;


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
