package com.fernando.gui;

public class ReacaoSelecao extends Reacao {
    ReacaoSelecao(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    void executar(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.CLIQUE)) {
            status = ReacaoStatusEnum.INICIADO;
            gerenciador.obterFiguras().forEach(x -> {
                if (x.clicouDentro(e)) {
                    gerenciador.iluminarFigura(x.obterId());
                }
            });
            status = ReacaoStatusEnum.FINALIZADO;
            anularReacao();
        }
    }
}
