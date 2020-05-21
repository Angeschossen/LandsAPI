package me.angeschossen.lands.api.role.enums;

import me.bytesoft.pluginapi.api.roles.settings.SettingType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.type.EnderChest;
import org.bukkit.block.data.type.Switch;
import org.bukkit.inventory.InventoryHolder;

public enum RoleSetting implements  me.bytesoft.pluginapi.api.roles.settings.RoleSetting {

    BLOCK_BREAK(0, "noaccess.break", ActionType.BLOCK),
    BLOCK_PLACE(1, "noaccess.place", ActionType.BLOCK),
    ATTACK_PLAYER(2, "noaccess.combat.pvp.attacker", ActionType.ENTITY),
    ATTACK_ANIMAL(3, "noaccess.combat.animal", ActionType.ENTITY),
    BLOCK_IGNITE(4, "noaccess.ignite", ActionType.BLOCK),
    INTERACT_GENERAL(5, "noaccess.interact.general", ActionType.BLOCK),
    INTERACT_MECHANISM(6, "noaccess.interact.mechanism", ActionType.BLOCK),
    INTERACT_CONTAINER(7, "noaccess.interact.container", ActionType.BLOCK),
    INTERACT_DOOR(8, "noaccess.interact.door", ActionType.BLOCK),
    INTERACT_VILLAGER(9, "noaccess.interact.villager", ActionType.ENTITY),
    FLY(10, "noaccess.fly", ActionType.OTHER),
    SPAWN_TELEPORT(11, null, ActionType.OTHER),
    LAND_ENTER(15, "noaccess.enter", ActionType.OTHER, true),
    VEHICLE_USE(16, "noaccess.vehicle", ActionType.ENTITY);


    public String iD;
    private final int id;
    public String message;
    public String bypassPermission;
    public String wildernessBypass;

    public final ActionType actionType;
    private final boolean allowIfWarOrWilderness;

    RoleSetting(int id, String message, ActionType actionType) {
        this(id, message, actionType, false);
    }

    RoleSetting(int id, String message, ActionType actionType, boolean allowIfWarOrWilderness) {
        this.iD = name().toLowerCase();
        this.allowIfWarOrWilderness = allowIfWarOrWilderness;
        this.id = id;
        this.message = message != null ? message : "noaccess.area";


        this.bypassPermission = "lands.bypass." + iD;
        this.wildernessBypass = "lands.bypass.wilderness." + iD;
        this.actionType = actionType;
    }


    public static RoleSetting getByID(String iD) {
        for (RoleSetting action : values()) {
            if (action.iD.equals(iD))
                return action;
        }

        throw new IllegalArgumentException("No RoleSetting with id '" + iD + "' found.");
    }

    public static RoleSetting getById(int iD) {
        for (RoleSetting action : values()) {
            if (action.getId() == iD)
                return action;
        }

        throw new IllegalArgumentException("No RoleSetting with id '" + iD + "' found.");
    }

    public static RoleSetting getInteractSetting(Block block) {
        if (block.getType() == Material.FARMLAND) {
            return RoleSetting.BLOCK_BREAK;
        }

        if (!block.getType().isInteractable()) return null;

        BlockData blockData = block.getState().getBlockData();
        if (blockData instanceof Openable) {
            return RoleSetting.INTERACT_DOOR;

        } else if (block.getState() instanceof InventoryHolder || blockData instanceof EnderChest) {
            return RoleSetting.INTERACT_CONTAINER;

        } else if (blockData instanceof Switch) {
            return RoleSetting.INTERACT_MECHANISM;

        } else {
            return RoleSetting.INTERACT_GENERAL;
        }
    }

    @Override
    public String toString() {
        return iD;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getBypassPermission() {
        return bypassPermission;
    }

    @Override
    public SettingType getType() {
        return SettingType.ACTION;
    }

    @Override
    public String getTogglePermission() {
        return "lands.role.setting." + toString();
    }

    @Override
    public String getMessageKey() {
        return message;
    }

    public String getWildernessBypass() {
        return wildernessBypass;
    }

    @Deprecated
    public String getMessage() {
        return message;
    }

    public boolean isAllowIfWarOrWilderness() {
        return allowIfWarOrWilderness;
    }
}
