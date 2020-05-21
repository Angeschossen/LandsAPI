package me.angeschossen.lands.api.role.enums;

public enum RoleSetting  {
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
    FLYER,
    SPAWN_TELEPORT,
    LAND_ENTER,
    VEHICLE_USE;



    public String getBypassPermission() {
        return null;
    }
}
