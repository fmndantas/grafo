package com.fernando.gui.graphics;

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

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.draw(getShape());
    }
}
