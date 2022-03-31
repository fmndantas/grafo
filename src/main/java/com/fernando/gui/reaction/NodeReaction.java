package com.fernando.gui.reaction;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReactionStatusEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.graphics.builder.NodeGuiBuilder;

public class NodeReaction extends Reaction {
    public NodeReaction(Manager manager) {
        super(manager);
    }

    @Override
    protected void executeReaction(EventGui e) {
        if (e.getEventType().equals(EventGuiEnum.PRESSURE)) {
            status = ReactionStatusEnum.INITIALIZED;
            var nodeGuiBuilder = new NodeGuiBuilder(manager.getNextFigureId());
            nodeGuiBuilder.buildShape(e.getXy());
            manager.addNode(nodeGuiBuilder.getResult());
            status = ReactionStatusEnum.FINALIZED;
        }
    }
}
