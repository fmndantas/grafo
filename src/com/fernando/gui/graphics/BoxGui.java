package com.fernando.gui.graphics;

import com.fernando.gui.event.EventGui;
import com.fernando.gui.utils.XY;

import java.awt.*;

public class BoxGui extends FigureGui {
    private final XY start;

    public BoxGui(Long id, Shape shape, XY start) {
        super(id, shape);
        this.start = start;
    }

    @Override
    public void moveAbsolute(XY target) {
        XY delta = start.delta(target);
        setShape(new Rectangle(start.getX(), start.getY(), delta.getX(), delta.getY()));
    }

    @Override
    public void moveRelatively(XY past, XY current) {
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0));
        g2.draw(getShape());
    }

    @Override
    public boolean clickedInside(EventGui e) {
        return false;
    }

    @Override
    public void updateAssociatedEntitiesBeforeExclusion() {

    }
}
