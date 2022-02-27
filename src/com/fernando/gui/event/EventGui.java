package com.fernando.gui.event;

import com.fernando.gui.utils.XY;
import com.fernando.gui.enums.EventGuiEnum;

// todo construir os outros eventos
public class EventGui {
    private XY xy;
    private EventGuiEnum eventType;

    public EventGui(XY xy, EventGuiEnum eventType) {
        this.xy = xy;
        this.eventType = eventType;
    }

    public XY getXy() {
        return this.xy;
    }

    public int getX() {
        return getXy().getX();
    }

    public int getY() {
        return getXy().getY();
    }

    public EventGuiEnum getEventType() {
        return this.eventType;
    }
}
