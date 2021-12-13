package com.fernando.gui.observer;

import com.fernando.gui.evento.EventoGui;
import com.fernando.gui.enums.EventoGrafoEnum;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Emissor extends JPanel {
    private List<Receptor> receptores = new ArrayList<>();

    public Emissor(GridLayout layout) {
        super(layout);
    }

    public void emitirEGui(EventoGui e) {
        receptores.forEach(r -> r.receberEGui(e));
    }

    public void emitirEGrafo(EventoGrafoEnum e) {
        receptores.forEach(r -> r.receberTipoEGrafo(e));
    }

    public void adicionarReceptor(Receptor receptor) {
        receptores.add(receptor);
    }
}
