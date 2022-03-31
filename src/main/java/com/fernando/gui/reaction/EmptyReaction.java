package com.fernando.gui.reaction;

import com.fernando.gui.Manager;
import com.fernando.gui.event.EventGui;

public class EmptyReaction extends Reaction {
    public EmptyReaction(Manager manager) {
        super(manager);
    }

    @Override
    protected void executeReaction(EventGui e) {

    }
}
