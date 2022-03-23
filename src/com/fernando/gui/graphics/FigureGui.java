package com.fernando.gui.graphics;

import com.fernando.gui.Emptable;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.utils.XY;

import java.awt.*;

public abstract class FigureGui implements Emptable {
    private final Long id;
    private Shape shape;
    private boolean selected;

    public FigureGui(Long id, Shape shape) {
        this.id = id;
        this.shape = shape;
        this.selected = false;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Long getId() {
        return id;
    }

    public boolean clickIsInside(EventGui click) {
        return xyIsInside(click.getXy());
    }

    private boolean xyIsInside(XY xy) {
        return shape.contains(xy.getX(), xy.getY());
    }

    public void selectFigure() {
        this.selected = true;
    }

    public void unselectFigure() {
        this.selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public abstract void moveAbsolute(XY target);

    public abstract void moveRelatively(XY past, XY current);

    public abstract void render(Graphics2D g2);

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public String toString() {
        return "FigureGui[Id=" + getId() + ", ]";
    }
}
