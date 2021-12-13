package com.fernando.gui;

public class ReacaoMover extends Reacao {
    private XY inicio;

    ReacaoMover(Gerenciador gerenciador) {
        super(gerenciador);
        this.inicio = new XY(-1, -1);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.CLIQUE)) {
            if (status == ReacaoStatusEnum.CRIADO) {
                status = ReacaoStatusEnum.INICIADO;
                inicio = e.obterXy();
            }
            else if (status == ReacaoStatusEnum.INICIADO) {
                status = ReacaoStatusEnum.FINALIZADO;
            }
        }
        else {
            if (e.obterTipoEvento().equals(EventGuiEnum.MOVIMENTO) && status == ReacaoStatusEnum.INICIADO) {
                this.gerenciador.moverFiguraSelecionada(e.obterXy());
            }
        }
    }

    @Override
    protected void executarDepoisReacao(EventoGui e) {
        super.executarDepoisReacao(e);
        gerenciador.atualizarQuadro();
    }
}
