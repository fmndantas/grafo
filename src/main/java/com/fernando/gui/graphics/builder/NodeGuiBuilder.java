package com.fernando.gui.graphics.builder;

import com.fernando.gui.utils.XY;
import com.fernando.gui.graphics.NodeGui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class NodeGuiBuilder {
    private Long id = -1L;
    private XY center = new XY(-1, -1);
    private Shape shape = null;
    private int radius = 20;

    public NodeGuiBuilder(Long id) {
        this.id = id;
    }

    public void buildShape(XY center) {
        this.center = center;
        this.shape = new Ellipse2D.Float(
                center.getX() - radius,
                center.getY() - radius,
                2 * radius,
                2 * radius
        );
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private void resetBuilder() {
        id = -1L;
        shape = null;
        center = new XY(-1, -1);
    }

    public NodeGui getResult() {
        var nodeGui = new NodeGui(id, shape, center);
        resetBuilder();
        return nodeGui;
    }
}
