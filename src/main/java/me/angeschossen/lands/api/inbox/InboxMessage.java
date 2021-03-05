package me.angeschossen.lands.api.inbox;


public interface InboxMessage {
    InboxCategory getCategory();

    long getTime();

    String getMessage();

    boolean appliesToFilter(InboxCategory type);
}
