package com.fernando.gui;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Quadro extends Emissor implements MouseInputListener {
    Gerenciador gerenciador;

    public Quadro(Gerenciador gerenciador) {
        super(new GridLayout(0, 1));
        addMouseMotionListener(this);
        addMouseListener(this);

        setPreferredSize(new Dimension(450, 450));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        this.gerenciador = gerenciador;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        emitirEGui(new EventoGui(new XY(e.getX(), e.getY()), EventGuiEnum.CLIQUE));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
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
        gerenciador.obterFiguras().forEach(x -> g2.draw(x.obterForma()));
    }

    protected void atualizarInterface() {
        repaint();
    }

    static void createAndShowGUI() {
        var moldura = new JFrame("Quadro");
        moldura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        var gerenciador = new Gerenciador();
        var quadro = new Quadro(gerenciador);
        var painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 0));
        var botaoSelecionar = new JButton("Selecionar");
        var botaoNo = new JButton("Inserir nó");
        var botaoAresta = new JButton("Inserir aresta");
        botaoSelecionar.addActionListener(e -> quadro.emitirEGrafo(EventoGrafoEnum.SELECIONAR));
        botaoNo.addActionListener(e -> quadro.emitirEGrafo(EventoGrafoEnum.INSERIR_NO));
        botaoAresta.addActionListener(e -> quadro.emitirEGrafo(EventoGrafoEnum.INSERIR_ARESTA));
        painelBotoes.add(botaoSelecionar);
        painelBotoes.add(botaoNo);
        painelBotoes.add(botaoAresta);
        gerenciador.setQuadro(quadro);
        var containerExterno = new JPanel();
        containerExterno.add(painelBotoes);
        containerExterno.add(quadro);
        quadro.adicionarReceptor(gerenciador);
        quadro.setOpaque(true);
        moldura.setContentPane(containerExterno);
        moldura.getContentPane().setLayout(new BoxLayout(moldura.getContentPane(), BoxLayout.Y_AXIS));
        moldura.pack();
        moldura.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Quadro::createAndShowGUI);
    }
}
