package com.fernando.gui.reacao;

import com.fernando.gui.*;
import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.ReacaoStatusEnum;
import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.utils.XY;

public class ReacaoMover extends Reacao {
    private XY inicio;

    public ReacaoMover(Gerenciador gerenciador) {
        super(gerenciador);
        this.inicio = new XY(-1, -1);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento().equals(EventGuiEnum.PRESSAO)) {
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
}
