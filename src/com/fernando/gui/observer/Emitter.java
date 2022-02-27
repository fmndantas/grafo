package com.fernando.gui.observer;

import com.fernando.gui.event.EventGui;
import com.fernando.gui.enums.EventGraphEnum;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Emitter extends JPanel {
    private List<Receptor> receptors = new ArrayList<>();

    public Emitter(GridLayout layout) {
        super(layout);
    }

    public void emitGuiEvent(EventGui e) {
        receptors.forEach(r -> r.receiveGuiEvent(e));
    }

    public void emitGraphEvent(EventGraphEnum e) {
        receptors.forEach(r -> r.receiveGraphEventType(e));
    }

    public void addReceptor(Receptor receptor) {
        receptors.add(receptor);
    }
}
