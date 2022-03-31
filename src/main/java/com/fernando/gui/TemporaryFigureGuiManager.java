package com.fernando.gui;

import com.fernando.gui.event.EventGui;
import com.fernando.gui.graphics.EmptyFigureGui;
import com.fernando.gui.graphics.FigureGui;
import com.fernando.gui.graphics.builder.BoxGuiBuilder;

import java.util.ArrayList;
import java.util.List;

public class TemporaryFigureGuiManager {
    private FigureGui selectionBox = new EmptyFigureGui();

    public TemporaryFigureGuiManager() {
    }

    public List<FigureGui> getFigures() {
        var result = new ArrayList<FigureGui>();
        if (!selectionBox.empty()) {
            result.add(selectionBox);
        }
        return result;
    }

    public void updateSelectionBox(EventGui e) {
        if (selectionBox.empty()) {
            selectionBox = new BoxGuiBuilder(e.getXy()).getResult();
        } else {
            selectionBox.moveAbsolute(e.getXy());
        }
    }

    public FigureGui getSelectionBox() {
        return selectionBox;
    }

    public void destroySelectionBox() {
        selectionBox = new EmptyFigureGui();
    }
}
