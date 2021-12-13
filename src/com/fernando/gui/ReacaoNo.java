package com.fernando.gui;

public class ReacaoNo extends Reacao {
    protected int RAIO_PADRAO = 25;

    ReacaoNo(Gerenciador gerenciador) {
        super(gerenciador);
    }

    @Override
    protected void executarReacao(EventoGui e) {
        if (e.obterTipoEvento() == EventGuiEnum.CLIQUE) {
            status = ReacaoStatusEnum.INICIADO;
            var noGuiBuilder = new NoGuiBuilder();
            noGuiBuilder.setarId(gerenciador.obterProximoId());
            noGuiBuilder.construirForma(e.obterXy());
            var noGui = noGuiBuilder.obterResultado();
            gerenciador.adicionarNo(noGui);
            status = ReacaoStatusEnum.FINALIZADO;
            System.out.println("Criou no em " + noGui.obterCentro());
        }
    }

    @Override
    protected void executarDepoisReacao(EventoGui e) {
        super.executarDepoisReacao(e);
        gerenciador.atualizarQuadro();
    }
}
