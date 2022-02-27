package com.fernando.gui.reaction;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReactionStatusEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.graphics.NodeGui;

public class SelectReaction extends Reaction {
    public SelectReaction(Manager manager) {
        super(manager);
    }

    @Override
    protected void executeReaction(EventGui e) {
        if (e.getEventType().equals(EventGuiEnum.PRESSURE)) {
            status = ReactionStatusEnum.INITIALIZED;
            for (NodeGui f : manager.getNodes()) {
                if (f.clickedIsInside(e)) {
                    this.manager.selectNode(f);
                } else {
                    this.manager.unselectNode(f);
                }
            }
            status = ReactionStatusEnum.FINALIZED;
        }
    }
}
