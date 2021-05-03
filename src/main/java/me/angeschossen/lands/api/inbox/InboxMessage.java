package me.angeschossen.lands.api.inbox;


public interface InboxMessage {
    InboxCategory getCategory();

    long getTime();

    String getText();

    String getTextWithDate();

    boolean appliesToFilter(InboxCategory type);
}
