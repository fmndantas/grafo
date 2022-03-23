package com.fernando.gui;

import com.fernando.gui.event.EventGui;
import com.fernando.gui.graphics.EdgeGui;
import com.fernando.gui.graphics.FigureGui;
import com.fernando.gui.graphics.NodeGui;
import com.fernando.gui.utils.XY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FigureGuiManager {
    private Long currentFigureId = 0L;
    private final List<NodeGui> nodesInGui;
    private final List<EdgeGui> edgesInGui;
    private final Set<NodeGui> selectedFigures;

    public FigureGuiManager() {
        this.nodesInGui = new ArrayList<>();
        this.edgesInGui = new ArrayList<>();
        this.selectedFigures = new HashSet<>();
    }

    public Long getNextFigureId() {
        return ++currentFigureId;
    }

    public void addEdge(EdgeGui edge) {
        this.edgesInGui.add(edge);
    }

    public List<EdgeGui> getEdges() {
        return this.edgesInGui;
    }

    public void addNode(NodeGui node) {
        this.nodesInGui.add(node);
    }

    public List<NodeGui> getNodes() {
        return this.nodesInGui;
    }

    public List<NodeGui> getGuiNodesUnderClick(EventGui e) {
        return this.nodesInGui.stream().filter(x -> x.clickIsInside(e)).toList();
    }

    public void selectNodesUnderClick(EventGui e) {
        emptySelection();
        nodesInGui.forEach(x -> {
            if (x.clickIsInside(e)) {
                selectedFigures.add(x);
                x.selectFigure();
            }
        });
    }

    public void selectNodesUnderSelectionBox(FigureGui selectionBox) {
        emptySelection();
        nodesInGui.forEach(x -> {
            if (selectionBox.getShape().contains(x.getShape().getBounds2D())) {
                selectedFigures.add(x);
                x.selectFigure();
            }
        });
    }

    public void moveSelectedGuiNodesRelatively(XY initial, XY current) {
        selectedFigures.forEach(x -> x.moveRelatively(initial, current));
    }

    public void emptySelection() {
        selectedFigures.forEach(FigureGui::unselectFigure);
        this.selectedFigures.clear();
    }
}
