package com.fernando.gui;

public class EventoGui {
    private XY xy;
    private EventGuiEnum tipoEvento;

    public EventoGui(XY xy, EventGuiEnum tipoEvento) {
        this.xy = xy;
        this.tipoEvento = tipoEvento;
    }

    XY obterXy() {
        return this.xy;
    }

    int obterX() {
        return obterXy().obterX();
    }

    int obterY() {
        return obterXy().obterY();
    }

    EventGuiEnum obterTipoEvento() {
        return this.tipoEvento;
    }
}
