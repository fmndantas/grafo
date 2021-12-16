package com.fernando.gui.utils;

public class XY {
    private int x;
    private int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int obterX() {
        return this.x;
    }

    public int obterY() {
        return this.y;
    }

    public double distancia2(XY outro) {
        double dx = Math.abs(this.x - outro.obterX());
        double dy = Math.abs(this.y - outro.obterY());
        return dx * dx + dy * dy;
    }

    public double distancia(XY outro) {
        return Math.sqrt(distancia2(outro));
    }

    @Override
    public String toString() {
        return "XY[x=" + this.obterX() + ", y=" + this.obterY() + "]";
    }
}
