package com.fernando.gui.grafico;

import com.fernando.gui.XY;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashSet;

public class NoGui extends FiguraGui {
    private HashSet<ArestaGui> arestas;
    private XY centro;

    public NoGui(Long id, Shape shape, XY centro) {
        super(id, shape);
        this.arestas = new HashSet<>();
        this.centro = centro;
    }

    public void adicionarAresta(ArestaGui aresta) {
        arestas.add(aresta);
    }

    public HashSet<ArestaGui> obterArestas() {
        return arestas;
    }

    public XY obterCentro() {
        return centro;
    }

    public void determinarCentro(XY centro) {
        this.centro = centro;
    }

    public int obterX() {
        return obterCentro().obterX();
    }

    public int obterY() {
        return obterCentro().obterY();
    }

    @Override
    public void moverAbsoluto(XY alvo) {
        var tx = new AffineTransform();
        tx.translate(
                alvo.obterX() - obterCentro().obterX(),
                alvo.obterY() - obterCentro().obterY()
        );
        determinarForma(tx.createTransformedShape(obterForma()));
        determinarCentro(alvo);
        for (ArestaGui a : obterArestas()) {
            a.moverPelosNosExtremos();
        }
    }
}
