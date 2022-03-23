package com.fernando.gui.graphics;

import com.fernando.gui.utils.XY;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NodeGui extends FigureGui {
    private final Set<EdgeGui> edges;
    private XY center;

    public NodeGui(Long id, Shape shape, XY center) {
        super(id, shape);
        this.edges = new HashSet<>();
        this.center = center;
    }

    public void addEdge(EdgeGui edge) {
        edges.add(edge);
    }

    public Set<EdgeGui> getEdges() {
        return Collections.unmodifiableSet(edges);
    }

    public XY getCenter() {
        return center;
    }

    public void setCenter(XY center) {
        this.center = center;
    }

    public int getX() {
        return getCenter().getX();
    }

    public int getY() {
        return getCenter().getY();
    }

    @Override
    public void moveAbsolute(XY target) {
        var af = new AffineTransform();
        af.translate(
                target.getX() - getCenter().getX(),
                target.getY() - getCenter().getY()
        );
        setShape(af.createTransformedShape(getShape()));
        setCenter(target);
        for (EdgeGui a : getEdges()) {
            a.moveByExtremeNodes();
        }
    }

    @Override
    public void moveRelatively(XY past, XY current) {
        var delta = past.delta(current);
        var af = new AffineTransform();
        af.translate(delta.getX(), delta.getY());
        setShape(af.createTransformedShape(getShape()));
        setCenter(new XY(getX() + delta.getX(), getY() + delta.getY()));
        for (EdgeGui a : getEdges()) {
            a.moveByExtremeNodes();
        }
    }

    @Override
    public void render(Graphics2D g2) {
        if (isSelected()) {
            g2.setColor(Color.GRAY);
        } else {
            g2.setColor(Color.WHITE);
        }
        g2.fill(getShape());
        g2.setColor(Color.BLACK);
        g2.draw(getShape());
    }
}
