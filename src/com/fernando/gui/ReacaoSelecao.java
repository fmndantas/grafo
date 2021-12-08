package com.fernando.gui;

public class ReacaoSelecao extends Reacao {
    ReacaoSelecao(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    void executar(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.CLIQUE)) {
            status = ReacaoStatusEnum.INICIADO;
            for (FiguraGui f : gerenciador.obterFiguras()) {
                if (f.clicouDentro(e)) {
                    System.out.println("Selecionou objeto " + f);
                    this.gerenciador.selecionarFigura(f);
                }
                else {
                    this.gerenciador.desselecionarFigura(f);
                }
            }
            status = ReacaoStatusEnum.FINALIZADO;
        }
        this.gerenciador.atualizarQuadro();
        if (status == ReacaoStatusEnum.FINALIZADO) {
            anularReacao();
        }
    }
}
