package com.fernando.gui.event;

import com.fernando.gui.utils.XY;
import com.fernando.gui.enums.EventGuiEnum;

// todo build other events
public class EventGui {
    private final XY xy;
    private final EventGuiEnum eventType;

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
