package com.fernando.gui;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashSet;

public class NoGui extends FiguraGui {
    HashSet<ArestaGui> arestas;

    NoGui(Long id, Shape shape, XY centro) {
        super(id, shape, centro);
        arestas = new HashSet<>();
    }

    void adicionarAresta(ArestaGui aresta) {
        arestas.add(aresta);
    }

    HashSet<ArestaGui> obterArestas() {
        return arestas;
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
