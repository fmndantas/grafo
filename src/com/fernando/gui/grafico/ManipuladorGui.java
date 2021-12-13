package com.fernando.gui.grafico;

import com.fernando.gui.XY;
import com.fernando.gui.grafico.FiguraGui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ManipuladorGui {
    private int RAIO_MANIPULADOR = 5;

    private FiguraGui figuraManipulada;
    private Shape shape;
    private boolean ativo;

    ManipuladorGui(XY centro, FiguraGui figuraManipulada) {
        this.ativo = false;
        this.figuraManipulada = figuraManipulada;
        this.shape = new Ellipse2D.Float(
                centro.obterX() - RAIO_MANIPULADOR,
                centro.obterY() - RAIO_MANIPULADOR,
                2 * RAIO_MANIPULADOR,
                2 * RAIO_MANIPULADOR
        );
    }

    public Shape obterForma() {
        return this.shape;
    }
}
