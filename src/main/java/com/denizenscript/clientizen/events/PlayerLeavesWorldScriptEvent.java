package com.denizenscript.clientizen.events;

import com.denizenscript.clientizen.objects.EntityTag;
import com.denizenscript.denizencore.events.ScriptEvent;
import com.denizenscript.denizencore.objects.ObjectTag;
import net.minecraft.entity.Entity;

public class PlayerLeavesWorldScriptEvent extends ScriptEvent {

    // <--[event]
    // @Events
    // player leave|leaves world
    //
    // @Group Player
    //
    // @Cancellable false
    //
    // @Triggers when the client player joins world.
    //
    // @Context
    // <context.entity> returns an EntityTag of the client player.
    //
    // -->

    public static PlayerLeavesWorldScriptEvent instance;

    public PlayerLeavesWorldScriptEvent() {
        instance = this;
        registerCouldMatcher("player leave|leaves world");
    }

    public EntityTag entity;

    @Override
    public boolean matches(ScriptPath path) {
        return super.matches(path);
    }

    @Override
    public ObjectTag getContext(String name) {
        return switch (name) {
            case "entity" -> entity;
            default -> super.getContext(name);
        };
    }

    public void handlePlayerLeave(Entity entity) {
        if (!eventData.isEnabled) {
            return;
        }
        fire();
    }
}
