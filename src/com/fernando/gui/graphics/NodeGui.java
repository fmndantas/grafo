package com.fernando.gui.graphics;

import com.fernando.gui.utils.XY;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashSet;

public class NodeGui extends FigureGui {
    private HashSet<EdgeGui> edges;
    private XY center;

    public NodeGui(Long id, Shape shape, XY center) {
        super(id, shape);
        this.edges = new HashSet<>();
        this.center = center;
    }

    public void addEdge(EdgeGui edge) {
        edges.add(edge);
    }

    public HashSet<EdgeGui> getEdges() {
        return edges;
    }

    public XY getCenter() {
        return center;
    }

    public void setCenter(XY centro) {
        this.center = centro;
    }

    public int getX() {
        return getCenter().getX();
    }

    public int getY() {
        return getCenter().getY();
    }

    @Override
    public void moveAbsolute(XY target) {
        var tx = new AffineTransform();
        tx.translate(
                target.getX() - getCenter().getX(),
                target.getY() - getCenter().getY()
        );
        setShape(tx.createTransformedShape(getShape()));
        setCenter(target);
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
