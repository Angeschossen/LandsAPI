package me.angeschossen.lands.api.flags;

import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public  class Flags {


    // land
    public static  RoleFlag BLOCK_BREAK;
    public static  RoleFlag BLOCK_PLACE;
    public static  RoleFlag ATTACK_PLAYER;
    public static  RoleFlag ATTACK_ANIMAL;
    public static  RoleFlag ATTACK_MONSTER;
    public static  RoleFlag BLOCK_IGNITE;
    public static  RoleFlag INTERACT_GENERAL;
    public static  RoleFlag INTERACT_MECHANISM;
    public static  RoleFlag INTERACT_CONTAINER;
    public static  RoleFlag INTERACT_DOOR;
    public static  RoleFlag INTERACT_VILLAGER;
    public static  RoleFlag FLY;
    public static  RoleFlag SPAWN_TELEPORT;
    public static  RoleFlag LAND_ENTER;
    public static  RoleFlag VEHICLE_USE;
    public static  RoleFlag ITEM_PICKUP;
    public static  RoleFlag ENDER_PEARL;
    public static  RoleFlag PLAYER_TRUST;
    public static  RoleFlag PLAYER_UNTRUST;
    public static  RoleFlag PLAYER_SETROLE;
    public static  RoleFlag LAND_CLAIM;
    public static  RoleFlag LAND_CLAIM_BORDER;
    public static  RoleFlag SPAWN_SET;
    public static  RoleFlag SETTING_EDIT_LAND;
    public static  RoleFlag SETTING_EDIT_ROLE;
    public static  RoleFlag SETTING_EDIT_TAXES;
    public static  RoleFlag SETTING_EDIT_VARIOUS;
    public static  RoleFlag BALANCE_WITHDRAW;
    public static  RoleFlag AREA_ASSIGN;
    public static  RoleFlag PLAYER_BAN;
    public static  RoleFlag WAR_MANAGE;

    public static  LandFlag ENTITY_GRIEFING;
    public static  LandFlag TNT_GRIEFING;
    public static  LandFlag PISTON_GRIEFING;
    public static  LandFlag MONSTER_SPAWN;
    public static  LandFlag ANIMAL_SPAWN;
    public static  LandFlag WATERFLOW_ALLOW;
    public static  LandFlag TITLE_HIDE;
    public static  LandFlag FIRE_SPREAD;
    public static  LandFlag LEAF_DECAY;
    public static  LandFlag PLANT_GROWTH;
    public static  LandFlag SNOW_MELT;

    // nation
    public static  RoleFlag NATION_EDIT;

    private Flags() {
    }

    public static void registerAll() {
    }

    @Nullable
    public static Flag get(@NotNull String name) {
        return null;
    }

    @Nullable
    public static RoleFlag getInteract(@NotNull Block block) {
        return null;
    }
}
