package com.fernando.gui.reacao;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReacaoStatusEnum;
import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.grafico.NoGui;

public class ReacaoSelecao extends Reacao {
    public ReacaoSelecao(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.PRESSAO)) {
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
    }
}
