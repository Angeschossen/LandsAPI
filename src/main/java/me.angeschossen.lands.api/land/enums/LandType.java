package me.angeschossen.lands.api.land.enums;


public enum LandType {
    LAND(0), ADMIN(1), CAMP(2);

    private static final LandType[] map = new LandType[]{LAND, ADMIN, CAMP};

    public final int id;

    LandType(int id) {
        this.id = id;
    }

    public static LandType getById(int id) {
        if (id >= map.length) {
            return LAND;
        }

        return map[id];
    }

    public boolean isSelectable() {
        return this != CAMP;
    }
}
