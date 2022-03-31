package com.fernando.gui.graphics;

import com.fernando.gui.event.EventGui;
import com.fernando.gui.utils.XY;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class EmptyFigureGui extends FigureGui {

    public EmptyFigureGui() {
        super(-1L, new Ellipse2D.Float(-1, -1, 0, 0));
    }

    @Override
    public void moveAbsolute(XY target) {

    }

    @Override
    public void moveRelatively(XY past, XY current) {

    }

    @Override
    public void render(Graphics2D g2) {

    }

    @Override
    public boolean empty() {
        return true;
    }

    @Override
    public boolean clickedInside(EventGui e) {
        return false;
    }

    @Override
    public void updateAssociatedEntitiesBeforeExclusion() {

    }
}
