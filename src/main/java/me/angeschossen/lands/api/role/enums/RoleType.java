package me.angeschossen.lands.api.role.enums;

public enum RoleType {
    OWNER(4, false, false), NATION(3, false), NORMAL(2, true, true), ENTRY(1, false), VISITOR(0, false);


    private final boolean multiple;
    private final int id;
    private boolean isDeleteable;

    RoleType(int id, boolean multiple) {
        this(id, multiple, false);
    }

    RoleType(int id, boolean multiple, boolean isDeleteable) {
        this.id = id;
        this.multiple = multiple;
        this.isDeleteable = isDeleteable;
    }

    public static RoleType getById(int id) throws IllegalArgumentException {
        for (RoleType roleType : values()) {
            if (roleType.getId() == id) {
                return roleType;
            }
        }

        throw new IllegalArgumentException("RoleType with id " + id + " not found.");
    }

    public int getId() {
        return id;
    }

    public boolean isSystem() {
        return this == NATION;
    }

    public boolean shouldCountOnNextFreePriority(){
        return this != NATION && this != VISITOR;
    }

    public boolean isDeleteable() {
        return isDeleteable;
    }

    public void setDeleteable(boolean deleteable) {
        isDeleteable = deleteable;
    }

    public boolean shouldAddToNewObject() {
        return this != NATION;
    }

    public boolean canMultiple() {
        return multiple;
    }
}
