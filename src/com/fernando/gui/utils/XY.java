package com.fernando.gui.utils;

public class XY {
    private final int x;
    private final int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public double distance2(XY outro) {
        double dx = Math.abs(this.x - outro.getX());
        double dy = Math.abs(this.y - outro.getY());
        return dx * dx + dy * dy;
    }

    public double distance(XY outro) {
        return Math.sqrt(distance2(outro));
    }

    @Override
    public String toString() {
        return "XY[x=" + this.getX() + ", y=" + this.getY() + "]";
    }
}
