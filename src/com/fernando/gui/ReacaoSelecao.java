package com.fernando.gui;

public class ReacaoSelecao extends Reacao {
    ReacaoSelecao(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.CLIQUE)) {
            status = ReacaoStatusEnum.INICIADO;
            for (NoGui f : gerenciador.obterNos()) {
                if (f.clicouDentro(e)) {
                    this.gerenciador.selecionarNo(f);
                } else {
                    this.gerenciador.desselecionarNo(f);
                }
            }
            status = ReacaoStatusEnum.FINALIZADO;
        }
        this.gerenciador.atualizarQuadro();
    }
}
