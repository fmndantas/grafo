package com.fernando.gui;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class FiguraGui implements ComForma {
    private Long id;
    private Shape shape;
    private XY centro;
    private boolean selecionado;

    FiguraGui(Long id, Shape shape, XY centro) {
        this.id = id;
        this.shape = shape;
        this.centro = centro;
        this.selecionado = false;
    }

    public Shape obterForma() {
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

    public void moverAbsoluto(XY alvo) {
        var tx = new AffineTransform();
        tx.translate(alvo.obterX() - obterCentro().obterX(), alvo.obterY() - obterCentro().obterY());
        shape = tx.createTransformedShape(shape);
        centro = alvo;
    }

    public void selecionarFigura() {
        this.selecionado = true;
    }

    public void desselecionarFigura() {
        this.selecionado = false;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    @Override
    public String toString() {
        return "FiguraGui[Id=" + obterId() + ", " + obterCentro() + "]";
    }
}
