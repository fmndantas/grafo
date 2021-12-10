package com.fernando.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Gerenciador extends Receptor {
    private Reacao reacao;
    private Quadro quadro;
    private Long idAtual = 1L;
    private FiguraGui figuraSelecionada;
    private List<NoGui> noGuis;
    private List<ArestaGui> arestaGuis;

    Gerenciador() {
        this.reacao = new ReacaoVazia(this);
        this.noGuis = new ArrayList<>();
        this.arestaGuis = new ArrayList<>();
        this.figuraSelecionada = null;
    }

    public void setQuadro(Quadro quadro) {
        this.quadro = quadro;
    }

    void estabelecerReacao() {
        switch (eventoGrafoEnum) {
            case INSERIR_ARESTA -> reacao = new ReacaoAresta(this);
            case INSERIR_NO -> reacao = new ReacaoNo(this);
            case SELECIONAR -> reacao = new ReacaoSelecao(this);
            case MOVER -> reacao = new ReacaoMover(this);
        }
    }

    @Override
    void receberEGui(EventoGui e) {
        super.receberEGui(e);
        reacao.executar(e);
    }

    @Override
    void receberTipoEGrafo(EventoGrafoEnum e) {
        super.receberTipoEGrafo(e);
        estabelecerReacao();
    }

    void adicionarAresta(ArestaGui arestaGui, NoGui inicio, NoGui fim) {
        this.arestaGuis.add(arestaGui);
        atualizarQuadro();
    }

    void adicionarNo(NoGui noGui) {
        this.noGuis.add(noGui);
        atualizarQuadro();
    }

    List<NoGui> obterNos() {
        return this.noGuis;
    }

    NoGui obterNoPeloClique(EventoGui e) {
        var candidatos = this.noGuis
                .stream()
                .filter(x -> x.clicouDentro(e))
                .collect(Collectors.toList());
        if (candidatos.size() == 1) {
            return candidatos.get(0);
        }
        return null;
    }

    List<FiguraGui> obterFiguras() {
        var figuras = new ArrayList<FiguraGui>();
        if (!noGuis.isEmpty())
            figuras.addAll(noGuis);
        if (!arestaGuis.isEmpty())
            figuras.addAll(arestaGuis);
        return figuras;
    }

    void atualizarQuadro() {
        quadro.atualizarQuadro();
    }

    Long obterProximoId() {
        return idAtual++;
    }

    public void selecionarNo(FiguraGui f) {
        f.selecionarFigura();
        figuraSelecionada = f;
    }

    public void desselecionarNo(NoGui noGui) {
        noGui.desselecionarFigura();
    }

    public void desselecionarTudo() {
        if (figuraSelecionada != null) {
            figuraSelecionada.desselecionarFigura();
            figuraSelecionada = null;
        }
    }

    public void moverFiguraSelecionada(XY alvoXY) {
        if (figuraSelecionada != null) {
            figuraSelecionada.moverAbsoluto(alvoXY);
        }
        atualizarQuadro();
    }
}
