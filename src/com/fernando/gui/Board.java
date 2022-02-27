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
    Manager manager;

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
    }

    protected void updateBoard() {
        repaint();
    }

    public static void createAndShowGUI() {
        var moldura = new JFrame("Board");
        moldura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var gerenciador = new Manager();
        var quadro = new Board(gerenciador);
        var painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 0));
        painelBotoes.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        var botaoSelecionar = new JButton("Selecionar");
        var botaoNo = new JButton("Inserir nó");
        var botaoAresta = new JButton("Inserir aresta");
        var botaoMover = new JButton("Mover");
        botaoSelecionar.addActionListener(e -> quadro.emitGraphEvent(EventGraphEnum.SELECT));
        botaoNo.addActionListener(e -> quadro.emitGraphEvent(EventGraphEnum.INSERT_NODE));
        botaoAresta.addActionListener(e -> quadro.emitGraphEvent(EventGraphEnum.INSERT_EDGE));
        botaoMover.addActionListener(e -> quadro.emitGraphEvent(EventGraphEnum.MOVE));
        painelBotoes.add(botaoSelecionar);
        painelBotoes.add(botaoNo);
        painelBotoes.add(botaoAresta);
        painelBotoes.add(botaoMover);
        gerenciador.setBoard(quadro);
        var containerExterno = new JPanel();
        containerExterno.add(painelBotoes);
        containerExterno.add(quadro);
        quadro.addReceptor(gerenciador);
        quadro.setOpaque(true);
        moldura.setContentPane(containerExterno);
        moldura
                .getContentPane()
                .setLayout(new BoxLayout(moldura.getContentPane(), BoxLayout.Y_AXIS));
        moldura.pack();
        moldura.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Board::createAndShowGUI);
    }
}
