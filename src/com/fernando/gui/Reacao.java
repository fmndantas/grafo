package com.fernando.gui;

public abstract class Reacao {
    protected Gerenciador gerenciador;
    protected ReacaoStatusEnum status;

    Reacao(Gerenciador gerenciador) {
        System.out.println("Iniciou " + this.getClass().getSimpleName());
        this.gerenciador = gerenciador;
        this.status = ReacaoStatusEnum.CRIADO;
    }

    public void executar(EventoGui e) {
        executarAntesReacao(e);
        executarReacao(e);
        executarDepoisReacao(e);
    }

    protected void executarAntesReacao(EventoGui e) {
    }

    protected void executarReacao(EventoGui e) {
    }

    protected void executarDepoisReacao(EventoGui e) {
        if (status == ReacaoStatusEnum.FINALIZADO) {
            renovarReacao();
            System.out.println("Finalizou " + this.getClass().getSimpleName());
        }
    }

    void renovarReacao() {
        status = ReacaoStatusEnum.CRIADO;
    }
}
