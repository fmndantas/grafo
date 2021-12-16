package com.fernando.gui.grafico;

import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.utils.XY;

import java.awt.*;

public abstract class FiguraGui {
    private Long id;
    private Shape shape;
    private boolean selecionado;

    public FiguraGui(Long id, Shape shape) {
        this.id = id;
        this.shape = shape;
        this.selecionado = false;
    }

    public Shape obterForma() {
        return shape;
    }

    public void determinarForma(Shape forma) {
        this.shape = forma;
    }

    public Long obterId() {
        return id;
    }

    public boolean clicouDentro(EventoGui clique) {
        return XyDentro(clique.obterXy());
    }

    private boolean XyDentro(XY xy) {
        return shape.contains(xy.obterX(), xy.obterY());
    }

    public void moverAbsoluto(XY alvo) {

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

    public abstract void renderizar(Graphics2D g2);

    @Override
    public String toString() {
        return "FiguraGui[Id=" + obterId() + ", ]";
    }
}
