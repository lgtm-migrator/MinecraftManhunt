/*
 * Copyright (c) 2020-2022 Radialbog9/TheJoeCoder and contributors.
 * You are allowed to use this code under the GPL3 license, which allows
 * commercial use, distribution, modification, and licensed works,
 * providing that you distribute your code under the same or similar license.
 */

package uk.radialbog9.spigot.manhunt.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;
import uk.radialbog9.spigot.manhunt.utils.GameEndCause;

/**
 * This event is for when the game ends
 */
@SuppressWarnings("unused")
public class ManhuntGameEndEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private GameEndCause endCause;

    /**
     * Initiates the event.
     * When GameEndCause e is not specified it defaults to ENDED_PREMATURELY.
     */
    public ManhuntGameEndEvent() { endCause = GameEndCause.ENDED_PREMATURELY; }

    /**
     * Initiates the event.
     * @param c GameEndCause game end cause
     */
    public ManhuntGameEndEvent(GameEndCause c) { endCause = c; }


    /**
     * Gets the win cause
     * @return GameEndCause end cause
     */
    public GameEndCause getEndCause() {
        return this.endCause;
    }

    /**
     * Sets the end cause
     * @param endCause GameEndCause end cause
     */
    public void setEndCause(GameEndCause endCause) {
        this.endCause = endCause;
    }


    @Override
    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
