package com.fernando.gui.graphics.builder;

import com.fernando.gui.graphics.EdgeGui;
import com.fernando.gui.graphics.NodeGui;

import java.awt.*;
import java.awt.geom.Line2D;

public class EdgeGuiBuilder {
    private Long id;
    private Shape shape = null;
    private NodeGui start = null;
    private NodeGui end = null;

    public EdgeGuiBuilder(Long id) {
        this.id = id;
    }

    public void buildShape(NodeGui start, NodeGui end) throws NullPointerException {
        if (start == null || end == null) {
            throw new NullPointerException("Both extreme nodes should be defined");
        }
        this.start = start;
        this.end = end;
        this.shape = new Line2D.Float(
                start.getX(),
                start.getY(),
                end.getX(),
                end.getY()
        );
    }

    private void resetBuilder() {
        id = -1L;
        shape = null;
        start = null;
        end = null;
    }

    public EdgeGui getResult() {
        var edgeGui = new EdgeGui(this.id, this.shape, this.start, this.end);
        this.start.addEdge(edgeGui);
        this.end.addEdge(edgeGui);
        resetBuilder();
        return edgeGui;
    }
}
