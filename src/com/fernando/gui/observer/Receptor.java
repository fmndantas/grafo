package com.fernando.gui.observer;

import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.evento.EventoGuiVazio;
import com.fernando.gui.enums.EventoGrafoEnum;

public class Receptor {
    protected EventoGrafoEnum eventoGrafoEnum;
    protected EventoGui eventoGui;

    public Receptor() {
        eventoGui = new EventoGuiVazio();
        eventoGrafoEnum = EventoGrafoEnum.VAZIO;
    }

    public void receberEGui(EventoGui e) {
        eventoGui = e;
    }

    public void receberTipoEGrafo(EventoGrafoEnum e) {
        eventoGrafoEnum = e;
    }
}
