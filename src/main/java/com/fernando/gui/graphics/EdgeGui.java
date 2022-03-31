package com.fernando.gui.graphics;

import com.fernando.gui.event.EventGui;
import com.fernando.gui.utils.XY;

import java.awt.*;
import java.awt.geom.Line2D;

public class EdgeGui extends FigureGui {
    private final NodeGui start;
    private final NodeGui end;

    public EdgeGui(Long id, Shape shape, NodeGui start, NodeGui end) {
        super(id, shape);
        this.start = start;
        this.end = end;
    }

    public void moveByExtremeNodes() {
        setShape(
                new Line2D.Float(
                        start.getX(),
                        start.getY(),
                        end.getX(),
                        end.getY()
                )
        );
    }

    public NodeGui getStart() {
        return start;
    }

    public NodeGui getEnd() {
        return end;
    }

    @Override
    public void moveAbsolute(XY target) {

    }

    @Override
    public void moveRelatively(XY past, XY target) {

    }

    @Override
    public void render(Graphics2D g2) {
        if (isSelected()) {
            g2.setColor(Color.PINK);
        }
        else {
            g2.setColor(Color.BLACK);
        }
        g2.draw(getShape());
    }

    @Override
    public boolean clickedInside(EventGui e) {
        var distance = Line2D.ptSegDist(start.getX(), start.getY(), end.getX(), end.getY(), e.getX(), e.getY());
        return distance < 2;
    }

    @Override
    public void updateAssociatedEntitiesBeforeExclusion() {
        start.removeEdge(this);
        end.removeEdge(this);
    }
}
