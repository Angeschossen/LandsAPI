package me.angeschossen.lands.api.role.enums;

public enum RoleSetting {
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


    public String getBypassPermission() {
        return null;
    }

}
