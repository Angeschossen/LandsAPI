package me.angeschossen.lands.api.inbox;

import me.angeschossen.lands.api.handler.APIHandler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public enum InboxCategory {

    ALL(0, 0), ECONOMY(1, 1),
    MEMBERS(2, 2), WAR(3, 3), RELATIONS(4, 4);

    private static final Map<Integer, InboxCategory> categories = new HashMap<>();

    static {
        for (InboxCategory i : values()) {
            categories.put(i.priority, i);
        }
    }

    public final int id;
    public final int priority;

    InboxCategory(int id, int prio) {
        this.id = id;
        this.priority = prio;
    }

    @NotNull
    public static InboxCategory getById(int id) {
        for (InboxCategory type : values()) {
            if (type.id == id) {
                return type;
            }
        }

        return InboxCategory.ALL;
    }

    @NotNull
    public static InboxCategory getByPriority(int prio) {
        return categories.getOrDefault(prio, ALL);
    }

    @NotNull
    public InboxCategory getNext() {
        InboxCategory inboxCategory = getByPriority(priority + 1);

        // if war is disabled and type is war, get next one after war. +2
        return APIHandler.getInstance().getWarsConfig().isEnabled() || inboxCategory != InboxCategory.WAR ? inboxCategory : getByPriority(priority + 2);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return APIHandler.getInstance().getGUIConfiguration().getString(this == ALL ? "all" : "inbox-filter." + toString());
    }
}
