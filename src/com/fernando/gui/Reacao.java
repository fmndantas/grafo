package com.fernando.gui;

public abstract class Reacao {
    protected Gerenciador gerenciador;
    protected ReacaoStatusEnum status;

    Reacao(Gerenciador gerenciador) {
        this.gerenciador = gerenciador;
        this.status = ReacaoStatusEnum.CRIADO;
    }

    void executar(EventoGui e) {
    }

    void anularReacao() {
        this.gerenciador.anularReacao();
    }
}
