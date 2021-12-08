package com.fernando.gui;

import java.awt.geom.Ellipse2D;

public class ReacaoNo extends Reacao {
    protected int RAIO_PADRAO = 25;

    ReacaoNo(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    void executar(EventoGui e) {
        if (e.obterTipoEvento() == EventGuiEnum.CLIQUE) {
            status = ReacaoStatusEnum.INICIADO;
            var diametro = 2 * RAIO_PADRAO;
            var shape = new Ellipse2D.Float(
                    e.obterX() - RAIO_PADRAO,
                    e.obterY() - RAIO_PADRAO,
                    diametro,
                    diametro
            );
            var circulo = new FiguraGui(gerenciador.obterProximoId(), shape, e.obterXy());
            // circulo.adicionarManipulador(new Manipulador(e.obterXy(), circulo));
            gerenciador.adicionarNo(circulo);
            status = ReacaoStatusEnum.FINALIZADO;
            anularReacao();
        }
    }
}
