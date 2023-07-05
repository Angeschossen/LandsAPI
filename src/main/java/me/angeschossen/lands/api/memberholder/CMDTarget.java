package me.angeschossen.lands.api.memberholder;

import org.jetbrains.annotations.NotNull;

public interface CMDTarget {
    static String parseCMDName(String in) {
        return in.replace(' ', '_');
    }

    @NotNull
    String getCMDName();
}
