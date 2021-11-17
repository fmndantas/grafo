package com.fernando.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Emissor extends JPanel {
    List<Receptor> receptores = new ArrayList<>();

    Emissor(GridLayout layout) {
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
