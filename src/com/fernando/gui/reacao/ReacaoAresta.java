package com.fernando.gui.reacao;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReacaoStatusEnum;
import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.grafico.NoGui;
import com.fernando.gui.grafico.builder.ArestaGuiBuilder;

public class ReacaoAresta extends Reacao {
    NoGui inicio;
    NoGui fim;

    public ReacaoAresta(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.PRESSAO)) {
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
                    var arestaGuiBuilder = new ArestaGuiBuilder();
                    arestaGuiBuilder.setarId(gerenciador.obterProximoId());
                    arestaGuiBuilder.construirForma(inicio, fim);
                    gerenciador.adicionarAresta(arestaGuiBuilder.obterResultado());
                    status = ReacaoStatusEnum.FINALIZADO;
                }
            }
        }
    }
}
