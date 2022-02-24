package me.angeschossen.lands.api.flags;

import com.google.common.base.Preconditions;
import me.angeschossen.lands.api.flags.types.LandFlag;
import me.angeschossen.lands.api.flags.types.RoleFlag;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Openable;
import org.bukkit.block.data.Powerable;
import org.bukkit.inventory.BlockInventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.PressureSensor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Flags {

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
    public static RoleFlag FLY;
    public static RoleFlag SPAWN_TELEPORT;
    public static RoleFlag LAND_ENTER;
    public static RoleFlag VEHICLE_USE;
    public static RoleFlag ITEM_PICKUP;
    public static RoleFlag ENDER_PEARL;
    public static RoleFlag TRAMPLE_FARMLAND;
    public static RoleFlag HARVEST;

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
    public static LandFlag ANIMAL_SPAWN;
    public static LandFlag WATERFLOW_ALLOW;
    public static LandFlag TITLE_HIDE;
    public static LandFlag FIRE_SPREAD;
    public static LandFlag LEAF_DECAY;
    public static LandFlag PLANT_GROWTH;
    public static LandFlag SNOW_MELT;

    // nation
    public static RoleFlag NATION_EDIT;


    private Flags() {
    }

    public static void registerAll() {
    }

    @Nullable
    public static Flag get(@NotNull String name) {
        Preconditions.checkNotNull(name, "Name cannot be null");
        return null;
    }

    @Nullable
    public static RoleFlag getInteract(@NotNull Block block) {
        return getInteract(block, null);
    }

    @Nullable
    public static RoleFlag getInteract(@NotNull Block block, @Nullable ItemStack item) {
        Preconditions.checkNotNull(block, "Block cannot be null");

        BlockData blockData = block.getBlockData();
        if (blockData instanceof Openable) {
            return Tag.TRAPDOORS.isTagged(block.getType()) ? INTERACT_TRAPDOOR : INTERACT_DOOR;
        } else if (block.getState() instanceof BlockInventoryHolder) {
            return INTERACT_CONTAINER;
        } else if (blockData instanceof Powerable || blockData instanceof PressureSensor) {
            return block.getType() == Material.LECTERN ? null : INTERACT_MECHANISM;
        } else {
            Material material = block.getType();
            switch (material) {
                case COMPOSTER: {
                    return item == null ? BLOCK_BREAK : BLOCK_PLACE;
                }

                case NOTE_BLOCK: {
                    return INTERACT_GENERAL;
                }

                case FLOWER_POT: {
                    return item == null ? null : BLOCK_PLACE;
                }

                case JUKEBOX: {
                    return INTERACT_CONTAINER;
                }

                default: {
                    return null;
                }
            }
        }
    }
}
