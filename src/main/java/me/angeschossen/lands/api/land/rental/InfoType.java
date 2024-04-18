package me.angeschossen.lands.api.land.rental;

public enum InfoType {
    HOLOGRAM(3), SIGN(1), CHAT(3);

    private final int maxTimeLength;
    InfoType(int maxTimeLength){
        this.maxTimeLength = maxTimeLength;
    }

    public int getMaxTimeLength() {
        return maxTimeLength;
    }
}
