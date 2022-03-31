package com.fernando.gui.reaction;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReactionStatusEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.graphics.NodeGui;

public class SingleSelectReaction extends Reaction {
    public SingleSelectReaction(Manager manager) {
        super(manager);
    }

    @Override
    protected void executeReaction(EventGui e) {
        if (e.getEventType().equals(EventGuiEnum.PRESSURE)) {
            status = ReactionStatusEnum.INITIALIZED;
            manager.selectNodesUnderClick(e);
            status = ReactionStatusEnum.FINALIZED;
        }
    }
}
