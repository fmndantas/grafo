package com.fernando.gui;

import com.fernando.gui.enums.EventGraphEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.graphics.EdgeGui;
import com.fernando.gui.graphics.FigureGui;
import com.fernando.gui.graphics.NodeGui;
import com.fernando.gui.observer.Receptor;
import com.fernando.gui.reacao.*;
import com.fernando.gui.utils.XY;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Receptor {
    private Reaction reaction;
    private Board board;
    private Long currentFigureId = 1L;
    private FigureGui selectFigure;
    private List<NodeGui> nodesInGui;
    private List<EdgeGui> edgesInGui;

    public Manager() {
        this.reaction = new EmptyReaction(this);
        this.nodesInGui = new ArrayList<>();
        this.edgesInGui = new ArrayList<>();
        this.selectFigure = null;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setReaction() {
        switch (graphEventType) {
            case INSERT_EDGE -> reaction = new EdgeReaction(this);
            case INSERT_NODE -> reaction = new NodeReaction(this);
            case SELECT -> reaction = new SelectReaction(this);
            case MOVE -> reaction = new MoveReaction(this);
        }
    }

    @Override
    public void receiveGuiEvent(EventGui e) {
        super.receiveGuiEvent(e);
        reaction.executeReactionInBackground(e);
    }

    @Override
    public void receiveGraphEventType(EventGraphEnum e) {
        super.receiveGraphEventType(e);
        setReaction();
    }

    public void addEdge(EdgeGui edgeGui) {
        this.edgesInGui.add(edgeGui);
    }

    public List<EdgeGui> getEdges() {
        return this.edgesInGui;
    }

    public void addNode(NodeGui nodeGui) {
        this.nodesInGui.add(nodeGui);
    }

    public List<NodeGui> getNodes() {
        return this.nodesInGui;
    }

    public NodeGui getNodeByClick(EventGui e) {
        var possibles = this.nodesInGui
                .stream()
                .filter(x -> x.clickedIsInside(e))
                .toList();
        if (possibles.size() == 1) {
            return possibles.get(0);
        }
        return null;
    }

    public void updateBoard() {
        board.updateBoard();
    }

    public Long getNextFigureId() {
        return currentFigureId++;
    }

    public void selectNode(FigureGui f) {
        f.selectFigure();
        selectFigure = f;
    }

    public void unselectNode(NodeGui nodeGui) {
        nodeGui.unselectFigure();
        if (nodeGui.equals(selectFigure)) {
            selectFigure = null;
        }
    }

    public void moveSelectFigure(XY alvoXY) {
        if (selectFigure != null) {
            selectFigure.moveAbsolute(alvoXY);
        }
    }
}
