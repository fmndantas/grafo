package com.fernando.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Manipulador implements ComForma {
    private int RAIO_MANIPULADOR = 5;

    private FiguraGui figuraManipulada;
    private Shape shape;
    private boolean ativo;

    Manipulador(XY centro, FiguraGui figuraManipulada) {
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
