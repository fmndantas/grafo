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
import java.util.stream.Collectors;

public class FigureGuiManager {
    private Long currentFigureId = 0L;
    private List<NodeGui> nodesInGui;
    private List<EdgeGui> edgesInGui;
    private final Set<FigureGui> selectedFigures;

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
        return this.nodesInGui.stream().filter(x -> x.clickedInside(e)).toList();
    }

    public void selectNodesUnderClick(EventGui e) {
        emptySelection();
        nodesInGui.forEach(x -> {
            if (x.clickedInside(e)) {
                selectedFigures.add(x);
                x.selectFigure();
            }
        });
    }

    public void selectEdgesUnderClick(EventGui e) {
        emptySelection();
        edgesInGui.forEach(x -> {
            if (x.clickedInside(e)) {
                selectedFigures.add(x);
                x.selectFigure();
            }
        });
    }

    public void selectNodesUnderSelectionBox(FigureGui selectionBox) {
        emptySelection();
        nodesInGui.forEach(x -> {
            if (selectionBox.containsFigureGui(x)) {
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

    public void eraseElementsUnderClick(EventGui e) {
        nodesInGui.forEach(x -> {
            if (x.clickedInside(e)) {
                edgesInGui = edgesInGui.stream().filter(y -> !x.getEdges().contains(y)).collect(Collectors.toList());;
                x.updateAssociatedEntitiesBeforeExclusion();
                nodesInGui = nodesInGui.stream().filter(y -> y != x).collect(Collectors.toList());
            }
        });
        edgesInGui.forEach(x -> {
            if (x.clickedInside(e)) {
                x.updateAssociatedEntitiesBeforeExclusion();
                edgesInGui = edgesInGui.stream().filter(y -> y != x).collect(Collectors.toList());
            }
        });

    }
}
