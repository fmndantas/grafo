package com.fernando.gui.grafico.builder;

import com.fernando.gui.grafico.ArestaGui;
import com.fernando.gui.grafico.NoGui;

import java.awt.*;
import java.awt.geom.Line2D;

public class ArestaGuiBuilder {
    private Long id = -1L;
    private Shape forma = null;
    private NoGui inicio = null;
    private NoGui fim = null;

    public void setarId(Long id) {
        this.id = id;
    }

    public void construirForma(NoGui inicio, NoGui fim) throws NullPointerException {
        if (inicio == null || fim == null) {
            throw new NullPointerException("As duas extremidades da aresta devem estar definidas");
        }
        this.inicio = inicio;
        this.fim = fim;
        this.forma = new Line2D.Float(
                inicio.obterX(),
                inicio.obterY(),
                fim.obterX(),
                fim.obterY()
        );
    }

    private void resetarParametros() {
        id = -1L;
        forma = null;
        inicio = null;
        fim = null;
    }

    public ArestaGui obterResultado() {
        var arestaGui = new ArestaGui(this.id, this.forma, this.inicio, this.fim);
        this.inicio.adicionarAresta(arestaGui);
        this.fim.adicionarAresta(arestaGui);
        resetarParametros();
        return arestaGui;
    }
}
