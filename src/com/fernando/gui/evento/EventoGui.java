package com.fernando.gui.evento;

import com.fernando.gui.XY;
import com.fernando.gui.enums.EventGuiEnum;

// todo construir os outros eventos
public class EventoGui {
    private XY xy;
    private EventGuiEnum tipoEvento;

    public EventoGui(XY xy, EventGuiEnum tipoEvento) {
        this.xy = xy;
        this.tipoEvento = tipoEvento;
    }

    public XY obterXy() {
        return this.xy;
    }

    public int obterX() {
        return obterXy().obterX();
    }

    public int obterY() {
        return obterXy().obterY();
    }

    public EventGuiEnum obterTipoEvento() {
        return this.tipoEvento;
    }
}
