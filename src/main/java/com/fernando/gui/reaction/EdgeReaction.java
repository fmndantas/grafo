package com.fernando.gui.reaction;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReactionStatusEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.graphics.NodeGui;
import com.fernando.gui.graphics.builder.EdgeGuiBuilder;

public class EdgeReaction extends Reaction {
    NodeGui start;
    NodeGui end;

    public EdgeReaction(Manager manager) {
        super(manager);
    }

    @Override
    protected void executeReaction(EventGui e) {
        if (e.getEventType().equals(EventGuiEnum.PRESSURE)) {
            if (status == ReactionStatusEnum.CREATED) {
                var possibilities = manager.getNodesUnderClick(e);
                if (possibilities.size() == 1) {
                    status = ReactionStatusEnum.INITIALIZED;
                    start = possibilities.get(0);
                }
            } else {
                var possibilities = manager.getNodesUnderClick(e);
                if (possibilities.size() == 1) {
                    end = possibilities.get(0);
                    var edgeGuiBuilder = new EdgeGuiBuilder(manager.getNextFigureId());
                    edgeGuiBuilder.buildShape(start, end);
                    manager.addEdge(edgeGuiBuilder.getResult());
                    status = ReactionStatusEnum.FINALIZED;
                }
            }
        }
    }
}
