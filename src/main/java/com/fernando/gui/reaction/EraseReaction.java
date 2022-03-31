package com.fernando.gui.reaction;

import com.fernando.gui.Manager;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReactionStatusEnum;
import com.fernando.gui.event.EventGui;

public class EraseReaction extends Reaction {
    public EraseReaction(Manager manager) {
        super(manager);
    }

    @Override
    protected void executeReaction(EventGui e) {
        if (e.getEventType().equals(EventGuiEnum.PRESSURE)) {
            status = ReactionStatusEnum.INITIALIZED;
            manager.eraseElements(e);
            status = ReactionStatusEnum.FINALIZED;
        }
    }
}
