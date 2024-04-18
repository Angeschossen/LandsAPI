package me.angeschossen.lands.api.memberholder;

import com.github.angeschossen.applicationframework.api.util.ULID;

public interface MemberHolderInfo {

    ULID getId();

    String getColorName();

    String getName();
}
