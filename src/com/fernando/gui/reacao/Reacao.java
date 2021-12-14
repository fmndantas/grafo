package com.fernando.gui.reacao;

import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.Gerenciador;
import com.fernando.gui.enums.ReacaoStatusEnum;

import javax.swing.*;

public abstract class Reacao {
    protected Gerenciador gerenciador;
    protected ReacaoStatusEnum status;

    public Reacao(Gerenciador gerenciador) {
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
        }
    }

    public void executarReacaoBackground(EventoGui e) {
        var worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                executar(e);
                return null;
            }
        };
        worker.execute();
    }

    void renovarReacao() {
        status = ReacaoStatusEnum.CRIADO;
    }
}
