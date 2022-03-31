package com.fernando.gui;

import com.fernando.gui.enums.EventGraphEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.graphics.EdgeGui;
import com.fernando.gui.graphics.FigureGui;
import com.fernando.gui.graphics.NodeGui;
import com.fernando.gui.observer.Receptor;
import com.fernando.gui.reaction.*;
import com.fernando.gui.utils.XY;

import java.util.List;

public class Manager extends Receptor {
    private Reaction reaction;
    private Board board;
    private final FigureGuiManager figureGuiManager;
    private final TemporaryFigureGuiManager temporaryFigureGuiManager;

    public Manager() {
        this.reaction = new EmptyReaction(this);
        this.figureGuiManager = new FigureGuiManager();
        this.temporaryFigureGuiManager = new TemporaryFigureGuiManager();
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setReaction() {
        switch (graphEventType) {
            case INSERT_EDGE -> reaction = new EdgeReaction(this);
            case INSERT_NODE -> reaction = new NodeReaction(this);
            case BOX_SELECT -> reaction = new BoxSelectReaction(this);
            case SELECT -> reaction = new SingleSelectReaction(this);
            case MOVE -> reaction = new MoveReaction(this);
            case ERASE -> reaction = new EraseReaction(this);
        }
    }

    public void updateBoard() {
        board.updateBoard();
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


    public Long getNextFigureId() {
        return figureGuiManager.getNextFigureId();
    }

    public void addEdge(EdgeGui edgeGui) {
        figureGuiManager.addEdge(edgeGui);
    }

    public List<EdgeGui> getEdges() {
        return figureGuiManager.getEdges();
    }

    public void addNode(NodeGui nodeGui) {
        figureGuiManager.addNode(nodeGui);
    }

    public List<NodeGui> getNodes() {
        return figureGuiManager.getNodes();
    }

    public List<NodeGui> getNodesUnderClick(EventGui e) {
        return figureGuiManager.getGuiNodesUnderClick(e);
    }

    public void selectNodesUnderClick(EventGui e) {
        figureGuiManager.selectNodesUnderClick(e);
    }

    public void selectEdgesUnderClick(EventGui e) {
        figureGuiManager.selectEdgesUnderClick(e);
    }

    public void moveSelectedGuiNodes(XY initial, XY current) {
        figureGuiManager.moveSelectedGuiNodesRelatively(initial, current);
    }

    public List<FigureGui> getTemporary() {
        return temporaryFigureGuiManager.getFigures();
    }

    public void updateSelectionBox(EventGui e) {
        temporaryFigureGuiManager.updateSelectionBox(e);
    }

    public void finalizeSelection() {
        var selectionBox = temporaryFigureGuiManager.getSelectionBox();
        figureGuiManager.selectNodesUnderSelectionBox(selectionBox);
        temporaryFigureGuiManager.destroySelectionBox();
    }

    public void eraseElements(EventGui e) {
        figureGuiManager.eraseElementsUnderClick(e);
    }
}
