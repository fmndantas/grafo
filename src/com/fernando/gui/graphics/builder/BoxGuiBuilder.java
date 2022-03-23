package com.fernando.gui.graphics.builder;

import com.fernando.gui.graphics.BoxGui;
import com.fernando.gui.utils.XY;

import java.awt.*;

public class BoxGuiBuilder {

    private final XY start;

    public BoxGuiBuilder(XY start) {
        this.start = start;
    }

    public BoxGui getResult() {
        var shape = new Rectangle(start.getX(), start.getY(), 0, 0);
        return new BoxGui(-1L, shape, start);
    }
}
