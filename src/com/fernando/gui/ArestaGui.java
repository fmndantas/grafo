package com.fernando.gui;

import java.awt.*;
import java.awt.geom.Line2D;

public class ArestaGui extends FiguraGui {
    FiguraGui inicio;
    FiguraGui fim;

    ArestaGui(Long id, Shape shape, XY centro, FiguraGui inicio, FiguraGui fim) {
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
