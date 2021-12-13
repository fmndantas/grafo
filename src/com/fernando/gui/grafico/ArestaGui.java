package com.fernando.gui.grafico;

import com.fernando.gui.XY;
import com.fernando.gui.grafico.FiguraGui;

import java.awt.*;
import java.awt.geom.Line2D;

public class ArestaGui extends FiguraGui {
    private FiguraGui inicio;
    private FiguraGui fim;

    public ArestaGui(Long id, Shape shape, XY centro, FiguraGui inicio, FiguraGui fim) {
        super(id, shape, centro);
        this.inicio = inicio;
        this.fim = fim;
    }

    public void moverPelosNosExtremos() {
        determinarForma(
                new Line2D.Float(
                        inicio.obterCentro().obterX(),
                        inicio.obterCentro().obterY(),
                        fim.obterCentro().obterX(),
                        fim.obterCentro().obterY()
                )
        );
    }
}
