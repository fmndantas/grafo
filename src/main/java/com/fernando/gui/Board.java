package com.fernando.gui;

import com.fernando.gui.enums.EventGuiEnum;
import com.fernando.gui.enums.EventGraphEnum;
import com.fernando.gui.event.EventGui;
import com.fernando.gui.observer.Emitter;
import com.fernando.gui.utils.XY;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Board extends Emitter implements MouseInputListener {
    private final Manager manager;

    public Board(Manager manager) {
        super(new GridLayout(0, 1));
        addMouseMotionListener(this);
        addMouseListener(this);

        setPreferredSize(new Dimension(450, 450));

        setBackground(Color.WHITE);
        this.manager = manager;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        emitGuiEvent(new EventGui(new XY(e.getX(), e.getY()), EventGuiEnum.DRAG));
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        emitGuiEvent(new EventGui(new XY(e.getX(), e.getY()), EventGuiEnum.MOVE));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        emitGuiEvent(new EventGui(new XY(e.getX(), e.getY()), EventGuiEnum.CLICK));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        emitGuiEvent(new EventGui(new XY(e.getX(), e.getY()), EventGuiEnum.PRESSURE));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        emitGuiEvent(new EventGui(new XY(e.getX(), e.getY()), EventGuiEnum.RELEASE));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2 = (Graphics2D) g;
        manager.getEdges().forEach(x -> x.render(g2));
        manager.getNodes().forEach(x -> x.render(g2));
        manager.getTemporary().forEach(x -> x.render(g2));
    }

    protected void updateBoard() {
        repaint();
    }

    public static void createAndShowGUI() {
        var frame = new JFrame("Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var manager = new Manager();
        var board = new Board(manager);
        var panelWithButtons = new JPanel();
        panelWithButtons.setLayout(new GridLayout(1, 0));
        panelWithButtons.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        var selectButton = new JButton("Select");
        var boxSelectButton = new JButton("Box select");
        var nodeButton = new JButton("Insert node");
        var edgeButton = new JButton("Insert edge");
        var moveButton = new JButton("Move");
        var eraseButton = new JButton("Erase");
        selectButton.addActionListener(e -> board.emitGraphEvent(EventGraphEnum.SELECT));
        boxSelectButton.addActionListener(e -> board.emitGraphEvent(EventGraphEnum.BOX_SELECT));
        nodeButton.addActionListener(e -> board.emitGraphEvent(EventGraphEnum.INSERT_NODE));
        edgeButton.addActionListener(e -> board.emitGraphEvent(EventGraphEnum.INSERT_EDGE));
        moveButton.addActionListener(e -> board.emitGraphEvent(EventGraphEnum.MOVE));
        eraseButton.addActionListener(e -> board.emitGraphEvent(EventGraphEnum.ERASE));
        panelWithButtons.add(selectButton);
        panelWithButtons.add(boxSelectButton);
        panelWithButtons.add(nodeButton);
        panelWithButtons.add(edgeButton);
        panelWithButtons.add(moveButton);
        panelWithButtons.add(eraseButton);
        manager.setBoard(board);
        var outerContainer = new JPanel();
        outerContainer.add(panelWithButtons);
        outerContainer.add(board);
        board.addReceptor(manager);
        board.setOpaque(true);
        frame.setContentPane(outerContainer);
        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Board::createAndShowGUI);
    }
}
