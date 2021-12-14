package com.fernando.gui.reacao;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReacaoStatusEnum;
import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.grafico.builder.NoGuiBuilder;

public class ReacaoNo extends Reacao {
    public ReacaoNo(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.PRESSAO)) {
            status = ReacaoStatusEnum.INICIADO;
            var noGuiBuilder = new NoGuiBuilder();
            noGuiBuilder.setarId(gerenciador.obterProximoId());
            noGuiBuilder.construirForma(e.obterXy());
            gerenciador.adicionarNo(noGuiBuilder.obterResultado());
            status = ReacaoStatusEnum.FINALIZADO;
        }
    }

    @Override
    protected void executarDepoisReacao(EventoGui e) {
        super.executarDepoisReacao(e);
        gerenciador.atualizarQuadro();
    }
}
