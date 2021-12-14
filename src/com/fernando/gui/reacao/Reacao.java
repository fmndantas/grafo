package com.fernando.gui.reacao;

import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.Gerenciador;
import com.fernando.gui.enums.ReacaoStatusEnum;

public abstract class Reacao {
    protected Gerenciador gerenciador;
    protected ReacaoStatusEnum status;

    public Reacao(Gerenciador gerenciador) {
        // System.out.println("Iniciou " + this.getClass().getSimpleName());
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
            // System.out.println("Finalizou " + this.getClass().getSimpleName());
            renovarReacao();
        }
    }

    void renovarReacao() {
        status = ReacaoStatusEnum.CRIADO;
    }
}
