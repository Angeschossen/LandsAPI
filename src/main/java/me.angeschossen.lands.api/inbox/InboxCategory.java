package me.angeschossen.lands.api.inbox;

import me.angeschossen.lands.api.handler.APIHandler;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public enum InboxCategory {

    ALL(0, 0),
    ECONOMY(1, 1),
    MEMBERS(2, 2),
    WAR(3, 3),
    RELATIONS(4, 4);

    private static final Map<Integer, InboxCategory> categories = new HashMap<>();

    static {
        for (InboxCategory i : values()) {
            categories.put(i.priority, i);
        }
    }

    public final int id;
    public final int priority;
    private boolean enabled = true;

    InboxCategory(int id, int prio) {
        this.id = id;
        this.priority = prio;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
        return inboxCategory.enabled ? inboxCategory : inboxCategory.getNext();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return APIHandler.getInstance().getGUIConfiguration().getString(this == ALL ? "all" : "inbox-filter." + toString());
    }
}
