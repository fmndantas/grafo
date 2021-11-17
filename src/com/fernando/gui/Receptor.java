package com.fernando.gui;

public class Receptor {
    protected EventoGrafoEnum eventoGrafoEnum;
    protected EventoGui eventoGui;

    Receptor() {
        eventoGui = new EventoGuiVazio();
        eventoGrafoEnum = EventoGrafoEnum.VAZIO;
    }

    void receberEGui(EventoGui e) {
        eventoGui = e;
    }

    void receberTipoEGrafo(EventoGrafoEnum e) {
        eventoGrafoEnum = e;
    }
}
