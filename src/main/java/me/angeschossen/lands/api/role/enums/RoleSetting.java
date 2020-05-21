package me.angeschossen.lands.api.role.enums;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.type.EnderChest;
import org.bukkit.block.data.type.Switch;
import org.bukkit.inventory.InventoryHolder;

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
    FLY,
    SPAWN_TELEPORT,
    LAND_ENTER,
    VEHICLE_USE;





    public String getBypassPermission() {
        return null;
    }

    public String getTogglePermission() {
        return null;
    }

    public String getMessageKey() {
        return null;
    }

    public String getWildernessBypass() {
        return null;
    }
}
