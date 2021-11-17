package com.fernando.gui;

import java.awt.geom.Line2D;

public class ReacaoAresta extends Reacao {
    FiguraGui inicio;
    FiguraGui fim;

    ReacaoAresta(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    void executar(EventoGui e) {
        if (e.obterTipoEvento() == EventGuiEnum.CLIQUE) {
            if (status == ReacaoStatusEnum.CRIADO) {
                var no = gerenciador.obterFiguraPeloXy(e.obterXy());
                if (no != null) {
                    status = ReacaoStatusEnum.INICIADO;
                    inicio = no;
                    System.out.println("Inicio em " + inicio.obterCentro());
                }
            } else {
                var no = gerenciador.obterFiguraPeloXy(e.obterXy());
                if (no != null) {
                    status = ReacaoStatusEnum.FINALIZADO;
                    fim = no;
                    System.out.println("Final em " + inicio.obterCentro());
                    var linha = new Line2D.Float(inicio.obterCentro().obterX(), inicio.obterCentro().obterY(), fim.obterCentro().obterX(), fim.obterCentro().obterY());
                    var figura = new FiguraGui(gerenciador.obterProximoId(), linha, new XY(-1, -1));
                    gerenciador.adicionarAresta(figura);
                    gerenciador.anularReacao();
                }
            }
        }
    }
}
