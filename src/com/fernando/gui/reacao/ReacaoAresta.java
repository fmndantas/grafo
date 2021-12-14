package com.fernando.gui.reacao;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReacaoStatusEnum;
import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.grafico.ArestaGui;
import com.fernando.gui.grafico.NoGui;

import java.awt.geom.Line2D;

public class ReacaoAresta extends Reacao {
    NoGui inicio;
    NoGui fim;

    public ReacaoAresta(Gerenciador gerenciador) {
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
                    // System.out.println("Selecionou inicio como " + no);
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
                    var arestaGui = new ArestaGui(
                            gerenciador.obterProximoId(),
                            linha,
                            inicio,
                            fim
                    );
                    inicio.adicionarAresta(arestaGui);
                    fim.adicionarAresta(arestaGui);
                    gerenciador.adicionarAresta(arestaGui);
                    status = ReacaoStatusEnum.FINALIZADO;
                    // System.out.println("Selecionou fim como " + no);
                }
            }
        }
    }

    @Override
    protected void executarDepoisReacao(EventoGui e) {
        super.executarDepoisReacao(e);
        gerenciador.atualizarQuadro();
    }
}
