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

    public double distance2(XY other) {
        double dx = Math.abs(this.x - other.getX());
        double dy = Math.abs(this.y - other.getY());
        return dx * dx + dy * dy;
    }

    public XY delta(XY destiny) {
        return new XY(destiny.getX() - getX(), destiny.getY() - getY());
    }

    @Override
    public String toString() {
        return "XY[x=" + this.getX() + ", y=" + this.getY() + "]";
    }
}
