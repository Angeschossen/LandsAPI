package me.angeschossen.lands.api.flags;

import com.google.common.base.Preconditions;
import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.PlayerFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Deprecated
public final class Flags {

    public static RoleFlag BLOCK_BREAK;
    public static RoleFlag BLOCK_PLACE;
    public static RoleFlag ATTACK_PLAYER;
    public static RoleFlag ATTACK_ANIMAL;
    public static RoleFlag ATTACK_MONSTER;
    public static RoleFlag BLOCK_IGNITE;
    public static RoleFlag INTERACT_GENERAL;
    public static RoleFlag INTERACT_MECHANISM;
    public static RoleFlag INTERACT_CONTAINER;
    public static RoleFlag INTERACT_DOOR;
    public static RoleFlag INTERACT_TRAPDOOR;
    public static RoleFlag INTERACT_VILLAGER;
    public static RoleFlag FLY, ELYTRA;
    public static RoleFlag SPAWN_TELEPORT;
    public static RoleFlag LAND_ENTER;
    public static RoleFlag VEHICLE_USE;
    public static RoleFlag ITEM_PICKUP;
    public static RoleFlag ENDER_PEARL;
    public static RoleFlag TRAMPLE_FARMLAND;
    public static RoleFlag HARVEST, PLANT, SHEAR;

    public static RoleFlag PLAYER_TRUST;
    public static RoleFlag PLAYER_UNTRUST;
    public static RoleFlag PLAYER_SETROLE;
    public static RoleFlag LAND_CLAIM;
    public static RoleFlag LAND_CLAIM_BORDER;
    public static RoleFlag SPAWN_SET;
    public static RoleFlag SETTING_EDIT_LAND;
    public static RoleFlag SETTING_EDIT_ROLE;
    public static RoleFlag SETTING_EDIT_TAXES;
    public static RoleFlag SETTING_EDIT_VARIOUS;
    public static RoleFlag BALANCE_WITHDRAW;
    public static RoleFlag AREA_ASSIGN;
    public static RoleFlag PLAYER_BAN;
    public static RoleFlag WAR_MANAGE;

    public static RoleFlag NO_DAMAGE;

    public static LandFlag ENTITY_GRIEFING;
    public static LandFlag TNT_GRIEFING;
    public static LandFlag PISTON_GRIEFING;
    public static LandFlag MONSTER_SPAWN;
    public static LandFlag PHANTOM_SPAWN;
    public static LandFlag ANIMAL_SPAWN;
    public static LandFlag WATERFLOW_ALLOW;
    public static LandFlag TITLE_HIDE;
    public static LandFlag REQUEST_ACCEPT;
    public static LandFlag FIRE_SPREAD;
    public static LandFlag LEAF_DECAY;
    public static LandFlag PLANT_GROWTH;
    public static LandFlag SNOW_MELT;

    // nation
    public static RoleFlag NATION_EDIT;

    // player
    public static PlayerFlag ENTER_MESSAGES;
    public static PlayerFlag RECEIVE_INVITES;


    public static void initializeLegacySupport() {
        BLOCK_BREAK = RoleFlag.of("BLOCK_BREAK");
        BLOCK_PLACE = RoleFlag.of("BLOCK_PLACE");
        ATTACK_PLAYER = RoleFlag.of("ATTACK_PLAYER");
        ATTACK_ANIMAL = RoleFlag.of("ATTACK_ANIMAL");
        ATTACK_MONSTER = RoleFlag.of("ATTACK_MONSTER");
        BLOCK_IGNITE = RoleFlag.of("BLOCK_IGNITE");
        INTERACT_GENERAL = RoleFlag.of("INTERACT_GENERAL");
        INTERACT_MECHANISM = RoleFlag.of("INTERACT_MECHANISM");
        INTERACT_CONTAINER = RoleFlag.of("INTERACT_CONTAINER");
        INTERACT_DOOR = RoleFlag.of("INTERACT_DOOR");
        INTERACT_TRAPDOOR = RoleFlag.of("INTERACT_TRAPDOOR");
        INTERACT_VILLAGER = RoleFlag.of("INTERACT_VILLAGER");
        FLY = RoleFlag.of("FLY");
        SPAWN_TELEPORT = RoleFlag.of("SPAWN_TELEPORT");
        LAND_ENTER = RoleFlag.of("LAND_ENTER");
        VEHICLE_USE = RoleFlag.of("VEHICLE_USE");
        ITEM_PICKUP = RoleFlag.of("ITEM_PICKUP");
        ENDER_PEARL = RoleFlag.of("ENDER_PEARL");
        TRAMPLE_FARMLAND = RoleFlag.of("TRAMPLE_FARMLAND");
        HARVEST = RoleFlag.of("HARVEST");
        PLANT = RoleFlag.of("PLANT");
        SHEAR = RoleFlag.of("SHEAR");
        PLAYER_TRUST = RoleFlag.of("PLAYER_TRUST");
        PLAYER_UNTRUST = RoleFlag.of("PLAYER_UNTRUST");
        PLAYER_SETROLE = RoleFlag.of("PLAYER_SETROLE");
        LAND_CLAIM = RoleFlag.of("LAND_CLAIM");
        LAND_CLAIM_BORDER = RoleFlag.of("LAND_CLAIM_BORDER");
        SPAWN_SET = RoleFlag.of("SPAWN_SET");
        SETTING_EDIT_LAND = RoleFlag.of("SETTING_EDIT_LAND");
        SETTING_EDIT_ROLE = RoleFlag.of("SETTING_EDIT_ROLE");
        SETTING_EDIT_TAXES = RoleFlag.of("SETTING_EDIT_TAXES");
        SETTING_EDIT_VARIOUS = RoleFlag.of("SETTING_EDIT_VARIOUS");
        BALANCE_WITHDRAW = RoleFlag.of("BALANCE_WITHDRAW");
        AREA_ASSIGN = RoleFlag.of("AREA_ASSIGN");
        PLAYER_BAN = RoleFlag.of("PLAYER_BAN");
        WAR_MANAGE = RoleFlag.of("WAR_MANAGE");
        NO_DAMAGE = RoleFlag.of("NO_DAMAGE");
        NATION_EDIT = RoleFlag.of("NATION_EDIT");
        ELYTRA = RoleFlag.of("ELYTRA");

        ENTITY_GRIEFING = LandFlag.of("ENTITY_GRIEFING");
        TNT_GRIEFING = LandFlag.of("TNT_GRIEFING");
        PISTON_GRIEFING = LandFlag.of("PISTON_GRIEFING");
        MONSTER_SPAWN = LandFlag.of("MONSTER_SPAWN");
        PHANTOM_SPAWN = LandFlag.of("PHANTOM_SPAWN");
        ANIMAL_SPAWN = LandFlag.of("ANIMAL_SPAWN");
        WATERFLOW_ALLOW = LandFlag.of("WATERFLOW_ALLOW");
        TITLE_HIDE = LandFlag.of("TITLE_HIDE");
        REQUEST_ACCEPT = LandFlag.of("REQUEST_ACCEPT");
        FIRE_SPREAD = LandFlag.of("FIRE_SPREAD");
        LEAF_DECAY = LandFlag.of("LEAF_DECAY");
        PLANT_GROWTH = LandFlag.of("PLANT_GROWTH");
        SNOW_MELT = LandFlag.of("SNOW_MELT");

        ENTER_MESSAGES = PlayerFlag.of("ENTER_MESSAGES");
        RECEIVE_INVITES = PlayerFlag.of("RECEIVE_INVITES");
    }

    private Flags() {
    }

    @Nullable
    public static Flag<?> get(@NotNull String name) {
        Preconditions.checkNotNull(name, "Name cannot be null");
        return null;
    }

    @Nullable
    public static RoleFlag getInteract(@NotNull Block block) {
        return null;
    }

    @Nullable
    public static RoleFlag getInteract(@NotNull Block block, @Nullable ItemStack item) {
        return null;
    }
}
