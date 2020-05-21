package me.angeschossen.lands.api.land;

import java.sql.Timestamp;

public interface NewsMessage {
    Timestamp getTime();

    String getMessage();
}
