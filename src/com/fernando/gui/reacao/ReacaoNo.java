package com.fernando.gui.reacao;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReacaoStatusEnum;
import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.grafico.builder.NoGuiBuilder;

public class ReacaoNo extends Reacao {
    protected int RAIO_PADRAO = 25;

    public ReacaoNo(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento() == EventGuiEnum.CLIQUE) {
            status = ReacaoStatusEnum.INICIADO;
            var noGuiBuilder = new NoGuiBuilder();
            noGuiBuilder.setarId(gerenciador.obterProximoId());
            noGuiBuilder.construirForma(e.obterXy());
            var noGui = noGuiBuilder.obterResultado();
            gerenciador.adicionarNo(noGui);
            status = ReacaoStatusEnum.FINALIZADO;
            System.out.println("Criou no em " + noGui.obterCentro());
        }
    }

    @Override
    protected void executarDepoisReacao(EventoGui e) {
        super.executarDepoisReacao(e);
        gerenciador.atualizarQuadro();
    }
}
