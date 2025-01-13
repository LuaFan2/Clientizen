package com.denizenscript.clientizen.events;

import com.denizenscript.clientizen.objects.EntityTag;
import com.denizenscript.denizencore.events.ScriptEvent;
import com.denizenscript.denizencore.objects.ObjectTag;
import net.minecraft.entity.Entity;

public class PlayerJoinsWorldScriptEvent extends ScriptEvent {

    // <--[event]
    // @Events
    // player join|joins world
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
    // @Example
    // # Will write greeting message on player join
    // on player joins world:
    // - narrate Greetings!
    // -->

    public static PlayerJoinsWorldScriptEvent instance;

    public PlayerJoinsWorldScriptEvent() {
        instance = this;
        registerCouldMatcher("player join|joins world");
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

    public void handlePlayerJoin(Entity entity) {
        if (!eventData.isEnabled) {
            return;
        }
        fire();
    }
}
