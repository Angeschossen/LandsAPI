package me.angeschossen.lands.api.flags;

import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import org.bukkit.block.Block;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class Flags {


    // land
    public static final RoleFlag BLOCK_BREAK = null;
    public static final RoleFlag BLOCK_PLACE = null;
    public static final RoleFlag ATTACK_PLAYER = null;
    public static final RoleFlag ATTACK_ANIMAL = null;
    public static final RoleFlag ATTACK_MONSTER = null;
    public static final RoleFlag BLOCK_IGNITE = null;
    public static final RoleFlag INTERACT_GENERAL = null;
    public static final RoleFlag INTERACT_MECHANISM = null;
    public static final RoleFlag INTERACT_CONTAINER = null;
    public static final RoleFlag INTERACT_DOOR = null;
    public static final RoleFlag INTERACT_TRAPDOOR = null;
    public static final RoleFlag INTERACT_VILLAGER = null;
    public static final RoleFlag FLY = null;
    public static final RoleFlag SPAWN_TELEPORT = null;
    public static final RoleFlag LAND_ENTER = null;
    public static final RoleFlag VEHICLE_USE = null;
    public static final RoleFlag ITEM_PICKUP = null;
    public static final RoleFlag ENDER_PEARL = null;
    public static final RoleFlag TRAMPLE_FARMLAND = null;

    public static final RoleFlag PLAYER_TRUST = null;
    public static final RoleFlag PLAYER_UNTRUST = null;
    public static final RoleFlag PLAYER_SETROLE = null;
    public static final RoleFlag LAND_CLAIM = null;
    public static final RoleFlag LAND_CLAIM_BORDER = null;
    public static final RoleFlag SPAWN_SET = null;
    public static final RoleFlag SETTING_EDIT_LAND = null;
    public static final RoleFlag SETTING_EDIT_ROLE = null;
    public static final RoleFlag SETTING_EDIT_TAXES = null;
    public static final RoleFlag SETTING_EDIT_VARIOUS = null;
    public static final RoleFlag BALANCE_WITHDRAW = null;
    public static final RoleFlag AREA_ASSIGN = null;
    public static final RoleFlag PLAYER_BAN = null;
    public static final RoleFlag WAR_MANAGE = null;

    public static final RoleFlag NO_DAMAGE = null;

    public static final LandFlag ENTITY_GRIEFING = null;
    public static final LandFlag TNT_GRIEFING = null;
    public static final LandFlag PISTON_GRIEFING = null;
    public static final LandFlag MONSTER_SPAWN = null;
    public static final LandFlag ANIMAL_SPAWN = null;
    public static final LandFlag WATERFLOW_ALLOW = null;
    public static final LandFlag TITLE_HIDE = null;
    public static final LandFlag FIRE_SPREAD = null;
    public static final LandFlag LEAF_DECAY = null;
    public static final LandFlag PLANT_GROWTH = null;
    public static final LandFlag SNOW_MELT = null;

    // nation
    public static final RoleFlag NATION_EDIT = null;

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
