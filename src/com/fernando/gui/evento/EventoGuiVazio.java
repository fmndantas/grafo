package com.fernando.gui.evento;

import com.fernando.gui.XY;
import com.fernando.gui.enums.EventGuiEnum;

public class EventoGuiVazio extends EventoGui {
    public EventoGuiVazio() {
        super(new XY(-1, -1), EventGuiEnum.VAZIO);
    }
}
