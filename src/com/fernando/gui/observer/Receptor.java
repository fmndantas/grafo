package com.fernando.gui.observer;

import com.fernando.gui.event.EventGui;
import com.fernando.gui.event.EmptyEventGui;
import com.fernando.gui.enums.EventGraphEnum;

public class Receptor {
    protected EventGraphEnum graphEventType;
    protected EventGui guiEventType;

    public Receptor() {
        guiEventType = new EmptyEventGui();
        graphEventType = EventGraphEnum.EMPTY;
    }

    public void receiveGuiEvent(EventGui e) {
        guiEventType = e;
    }

    public void receiveGraphEventType(EventGraphEnum e) {
        graphEventType = e;
    }
}
