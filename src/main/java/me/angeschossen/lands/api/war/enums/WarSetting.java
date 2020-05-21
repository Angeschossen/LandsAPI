package me.angeschossen.lands.api.war.enums;

public enum WarSetting {

    FRIENDLY_FIRE(1);

    private final int id;

    WarSetting(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static WarSetting getById(int id) throws IllegalArgumentException{
        for (WarSetting warSetting : values()) {
            if (warSetting.getId() == id) {
                return warSetting;
            }
        }

        throw new IllegalArgumentException("No warsetting with id " + id + " found.");
    }
}
