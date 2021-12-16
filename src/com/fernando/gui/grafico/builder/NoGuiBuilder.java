package com.fernando.gui.grafico.builder;

import com.fernando.gui.utils.XY;
import com.fernando.gui.grafico.NoGui;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class NoGuiBuilder {
    private Long id = -1L;
    private XY centro = new XY(-1, -1);
    private Shape forma = null;
    private int raio = 20;

    public NoGuiBuilder() {
    }

    public void setarId(Long id) {
        this.id = id;
    }

    public void construirForma(XY centro) {
        this.centro = centro;
        this.forma = new Ellipse2D.Float(
                centro.obterX() - raio,
                centro.obterY() - raio,
                2 * raio,
                2 * raio
        );
    }

    public void setarRaio(int raio) {
        this.raio = raio;
    }

    private void resetarParametros() {
        id = -1L;
        forma = null;
        centro = new XY(-1, -1);
    }

    public NoGui obterResultado() {
        var noGui = new NoGui(id, forma, centro);
        resetarParametros();
        return noGui;
    }
}
