package com.fernando.gui.reaction;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReactionStatusEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.utils.XY;

public class MoveReaction extends Reaction {
    private XY start;
    private XY past;

    public MoveReaction(Manager manager) {
        super(manager);
        this.start = new XY(-1, -1);
        this.past = new XY(-1, -1);
    }

    @Override
    protected void executeReaction(EventGui e) {
        if (e.getEventType().equals(EventGuiEnum.PRESSURE)) {
            if (status == ReactionStatusEnum.CREATED) {
                status = ReactionStatusEnum.INITIALIZED;
                if (start.getX() == -1 && start.getY() == -1) {
                    start = e.getXy();
                    past = e.getXy();
                }
            } else if (status == ReactionStatusEnum.INITIALIZED) {
                status = ReactionStatusEnum.FINALIZED;
                this.start = new XY(-1, -1);
                this.past = new XY(-1, -1);
            }
        } else {
            if (e.getEventType().equals(EventGuiEnum.MOVE) && status == ReactionStatusEnum.INITIALIZED) {
                this.manager.moveSelectedGuiNodes(past, e.getXy());
                past = e.getXy();
            }
        }
    }
}
