package me.angeschossen.lands.api.role.enums;

public enum RoleSetting implements SettingRole {
    BLOCK_BREAK(0, "noaccess.break", false, ActionType.BLOCK),
    BLOCK_PLACE(1, "noaccess.place", false, ActionType.BLOCK),
    ATTACK_PLAYER(2, "noaccess.combat.pvp.attacker", false, ActionType.ENTITY),
    ATTACK_ANIMAL(3, "noaccess.combat.animal", false, ActionType.ENTITY),
    BLOCK_IGNITE(4, "noaccess.ignite", false, ActionType.BLOCK),
    INTERACT_GENERAL(5, "noaccess.interact.general", false, ActionType.BLOCK),
    INTERACT_MECHANISM(6, "noaccess.interact.mechanism", false, ActionType.BLOCK),
    INTERACT_CONTAINER(7, "noaccess.interact.container", false, ActionType.BLOCK),
    INTERACT_DOOR(8, "noaccess.interact.door", false, ActionType.BLOCK),
    INTERACT_VILLAGER(9, "noaccess.interact.villager", false, ActionType.ENTITY),
    FLY(10, "", false, ActionType.OTHER),
    SPAWN_TELEPORT(11, "", false, ActionType.OTHER),


    //War
    PLACE_LADDER(12, "", false, ActionType.BLOCK),
    PLACE_SCAFFOLDING(13, "", false, ActionType.BLOCK),
    PLACE_VINE(14, "", false, ActionType.BLOCK);


    public String iD;
    private final int id;
    public String message;
    public String bypassPermission;
    public final ActionType actionType;

    RoleSetting(int id, String message, boolean isAdmin, ActionType actionType) {
        this.iD = name().toLowerCase();
        this.id = id;
        this.message = message;

        if (!isAdmin)
            this.bypassPermission = "lands.bypass." + iD;
        else this.bypassPermission = "lands.admin." + iD;

        this.actionType = actionType;
    }


    public static RoleSetting getByID(String iD) {
        for (RoleSetting action : values()) {
            if (action.iD.equals(iD))
                return action;
        }

        throw new IllegalArgumentException("No LandsAction with iD '" + iD + "' found.");
    }

    public static RoleSetting getById(int iD) {
        for (RoleSetting action : values()) {
            if (action.getId() == iD)
                return action;
        }

        throw new IllegalArgumentException("No LandsAction with iD '" + iD + "' found.");
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
        return SettingType.ROLE;
    }
}
