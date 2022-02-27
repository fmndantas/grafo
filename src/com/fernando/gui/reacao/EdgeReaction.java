package com.fernando.gui.reacao;

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
                var startNode = manager.getNodeByClick(e);
                if (startNode != null) {
                    status = ReactionStatusEnum.INITIALIZED;
                    start = startNode;
                }
            } else {
                var endNode = manager.getNodeByClick(e);
                if (endNode != null) {
                    end = endNode;
                    var edgeGuiBuilder = new EdgeGuiBuilder();
                    edgeGuiBuilder.setId(manager.getNextFigureId());
                    edgeGuiBuilder.buildShape(start, end);
                    manager.addEdge(edgeGuiBuilder.getResult());
                    status = ReactionStatusEnum.FINALIZED;
                }
            }
        }
    }
}
