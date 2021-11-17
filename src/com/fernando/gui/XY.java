package com.fernando.gui;

public class XY {
    private int x;
    private int y;

    XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int obterX() {
        return this.x;
    }

    int obterY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "XY[x=" + this.obterX() + ", y=" + this.obterY() + "]";
    }
}
