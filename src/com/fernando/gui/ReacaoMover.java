package com.fernando.gui;

public class ReacaoMover extends Reacao {
    private XY inicio;

    ReacaoMover(Gerenciador gerenciador) {
        super(gerenciador);
        this.inicio = new XY(-1, -1);
    }

    @Override
    void executar(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.CLIQUE)) {
            if (status == ReacaoStatusEnum.CRIADO) {
                status = ReacaoStatusEnum.INICIADO;
                inicio = e.obterXy();
                System.out.println("Iniciou em " + e.obterXy());
            }
            else if (status == ReacaoStatusEnum.INICIADO) {
                status = ReacaoStatusEnum.FINALIZADO;
                System.out.println("Finalizou em " + e.obterXy());
            }
        }
        else {
            if (e.obterTipoEvento().equals(EventGuiEnum.MOVIMENTO) && status == ReacaoStatusEnum.INICIADO) {
                System.out.println("Moveu relativo de " + e.obterXy().distancia(inicio));
            }
        }
        if (status == ReacaoStatusEnum.FINALIZADO) {
            anularReacao();
        }
    }
}
