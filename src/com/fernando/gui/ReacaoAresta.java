package com.fernando.gui;

import java.awt.geom.Line2D;

public class ReacaoAresta extends Reacao {
    NoGui inicio;
    NoGui fim;

    ReacaoAresta(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento() == EventGuiEnum.CLIQUE) {
            if (status == ReacaoStatusEnum.CRIADO) {
                var no = gerenciador.obterNoPeloClique(e);
                if (no != null) {
                    status = ReacaoStatusEnum.INICIADO;
                    inicio = no;
                }
            } else {
                var no = gerenciador.obterNoPeloClique(e);
                if (no != null) {
                    fim = no;
                    var linha = new Line2D.Float(
                            inicio.obterCentro().obterX(),
                            inicio.obterCentro().obterY(),
                            fim.obterCentro().obterX(),
                            fim.obterCentro().obterY()
                    );
                    var arestaGui = new ArestaGui(gerenciador.obterProximoId(), linha, new XY(-1, -1));
                    gerenciador.adicionarAresta(arestaGui, inicio, fim);
                    status = ReacaoStatusEnum.FINALIZADO;
                }
            }
        }
    }
}
