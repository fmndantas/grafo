package com.fernando.gui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class NoGuiBuilder {
    private Long id = -1L;
    private XY centro = new XY(-1, -1);
    private Shape forma = null;
    private int raio = 20;

    NoGuiBuilder() {
    }

    void setarId(Long id) {
        this.id = id;
    }

    void construirForma(XY centro) {
        this.centro = centro;
        this.forma = new Ellipse2D.Float(
                centro.obterX() - raio,
                centro.obterY() - raio,
                2 * raio,
                2 * raio
        );
    }

    void setarRaio(int raio) {
        this.raio = raio;
    }

    void resetarParametros() {
        id = -1L;
        forma = null;
        centro = new XY(-1, -1);
    }

    NoGui obterResultado() {
        var noGui = new NoGui(id, forma, centro);
        resetarParametros();
        return noGui;
    }
}
