package com.fernando.gui.graphics;

import com.fernando.gui.Emptable;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.utils.XY;

import java.awt.*;
import java.awt.geom.Rectangle2D;

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

    public void selectFigure() {
        this.selected = true;
    }

    public void unselectFigure() {
        this.selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public boolean containsFigureGui(FigureGui another) {
        return this.shape.contains(another.getBounds());
    }

    public Rectangle2D getBounds() {
        return this.shape.getBounds2D();
    }

    public abstract void moveAbsolute(XY target);

    public abstract void moveRelatively(XY past, XY current);

    public abstract void render(Graphics2D g2);

    public abstract boolean clickedInside(EventGui e);

    public abstract void updateAssociatedEntitiesBeforeExclusion();

    @Override
    public boolean empty() {
        return false;
    }

    @Override
    public String toString() {
        return "FigureGui[Id=" + getId() + "]";
    }
}
