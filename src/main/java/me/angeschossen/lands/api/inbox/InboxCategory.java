package me.angeschossen.lands.api.inbox;

import org.jetbrains.annotations.NotNull;

public enum InboxCategory {

    ALL(0, 0), ECONOMY(1, 1),
    MEMBERS(2, 2), WAR(3, 3), RELATIONS(4, 4);

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
        for (InboxCategory type : values()) {
            if (type.priority == prio) {
                return type;
            }
        }

        //looks like parameter was max
        return InboxCategory.ALL;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return null;
    }

    @NotNull
    public InboxCategory getNext() {
        return null;
    }
}
