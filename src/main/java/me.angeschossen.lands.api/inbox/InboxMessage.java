package me.angeschossen.lands.api.inbox;


import com.github.angeschossen.pluginframework.api.events.ExpressionEntity;

public interface InboxMessage extends ExpressionEntity {
    InboxCategory getCategory();

    long getTime();

    String getText();

    String getTextWithDate();

    boolean appliesToFilter(InboxCategory type);
}
