package com.fernando.gui;

import java.awt.*;

public class FiguraGui {
    private Long id;
    private Shape shape;
    private XY centro;

    FiguraGui(Long id, Shape shape, XY centro) {
        this.id = id;
        this.shape = shape;
        this.centro = centro;
    }

    Shape obterForma() {
        return shape;
    }

    Long obterId() {
        return id;
    }

    boolean clicouDentro(EventoGui clique) {
        return shape.contains(clique.obterX(), clique.obterY());
    }

    boolean XyDentro(XY xy) {
        return shape.contains(xy.obterX(), xy.obterY());
    }

    public XY obterCentro() {
        return centro;
    }

    @Override
    public String toString() {
        return "FiguraGui[Id=" + obterId() + ", " + obterCentro() + "]";
    }
}
