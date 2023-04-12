package me.angeschossen.lands.api.role.enums;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public enum RoleType {
    ALLY(5, false, false, false), OWNER(4, false, false, true), NATION(3, false, false, false), NORMAL(2, true, true, true), ENTRY(1, false, false, true), VISITOR(0, false, false, false);

    private static final Map<Integer, RoleType> map = new HashMap<>();
public boolean isLand(){
    return this != NATION;
}
    static {
        for (RoleType roleType : values()) {
            map.put(roleType.id, roleType);
        }
    }

    private final boolean multiple;
    private final int id;
    private final boolean canHaveMembers;
    private boolean isDeleteable;
    RoleType(int id, boolean multiple, boolean isDeleteable, boolean canHaveMembers) {
        this.id = id;
        this.multiple = multiple;
        this.isDeleteable = isDeleteable;
        this.canHaveMembers = canHaveMembers;
    }

    @NotNull
    public static RoleType getById(int id) {
        return map.getOrDefault(id, NORMAL);
    }

    public boolean canApply() {
        return this == NORMAL || this == ENTRY;
    }

    public boolean canHaveMembers() {
        return canHaveMembers;
    }

    public boolean canMultiple() {
        return multiple;
    }

    public int getId() {
        return id;
    }

    public boolean isDeleteable() {
        return isDeleteable;
    }

    public void setDeleteable(boolean deleteable) {
        isDeleteable = deleteable;
    }

    public boolean isSystem() {
        return !canHaveMembers;
    }

    public final boolean paysTaxes() {
        return this == NORMAL || this == ENTRY;
    }

    public boolean shouldAddToNewObject() {
        // nation role is only needed if land is part of nation
        return this != NATION;
    }
}
