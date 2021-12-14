package com.fernando.gui.grafico;

import java.awt.*;
import java.awt.geom.Line2D;

public class ArestaGui extends FiguraGui {
    private NoGui inicio;
    private NoGui fim;

    public ArestaGui(Long id, Shape shape, NoGui inicio, NoGui fim) {
        super(id, shape);
        this.inicio = inicio;
        this.fim = fim;
    }

    public void moverPelosNosExtremos() {
        determinarForma(
                new Line2D.Float(
                        inicio.obterX(),
                        inicio.obterY(),
                        fim.obterX(),
                        fim.obterY()
                )
        );
    }
}
