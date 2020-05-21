package me.angeschossen.lands.internal.api.roles.enums;

public enum RoleType {
    NORMAL(2, true), ENTRY(1, false), VISITOR(0, false);


    private final boolean multiple;
    private final int id;

    RoleType(int id, boolean multiple) {
        this.multiple = multiple;
        this.id = id;
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

    public boolean canMultiple() {
        return multiple;
    }
}
