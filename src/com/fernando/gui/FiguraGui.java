package com.fernando.gui;

import java.awt.*;

public abstract class FiguraGui {
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

    public void determinarForma(Shape forma) {
        this.shape = forma;
    }

    Long obterId() {
        return id;
    }

    public void determinarId(Long id) {
        this.id = id;
    }

    boolean clicouDentro(EventoGui clique) {
        return XyDentro(clique.obterXy());
    }

    boolean XyDentro(XY xy) {
        return shape.contains(xy.obterX(), xy.obterY());
    }

    public XY obterCentro() {
        return centro;
    }

    public void determinarCentro(XY centro) {
        this.centro = centro;
    }

    protected void moverAbsoluto(XY alvo) {

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
