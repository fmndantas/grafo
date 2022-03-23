package com.fernando.gui.reaction;

import com.fernando.gui.Manager;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReactionStatusEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.utils.XY;

public class BoxSelectReaction extends Reaction {
    XY start;

    public BoxSelectReaction(Manager manager) {
        super(manager);
        start = new XY(-1, -1);
    }

    @Override
    protected void executeReaction(EventGui e) {
        if (e.getEventType().equals(EventGuiEnum.PRESSURE)) {
            if (status == ReactionStatusEnum.CREATED) {
                status = ReactionStatusEnum.INITIALIZED;
                start = e.getXy();
                manager.updateSelectionBox(e);
            } else if (status == ReactionStatusEnum.INITIALIZED) {
                status = ReactionStatusEnum.FINALIZED;
                manager.finalizeSelection();
            }
        }
        if (e.getEventType().equals(EventGuiEnum.MOVE) && status == ReactionStatusEnum.INITIALIZED) {
            if (e.getEventType().equals(EventGuiEnum.MOVE)) {
                manager.updateSelectionBox(e);
            }
        }
    }
}
