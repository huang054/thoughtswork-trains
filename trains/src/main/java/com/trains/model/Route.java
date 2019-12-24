package com.trains.model;



public class Route implements Comparable<Route>{

    private final Point from;

    private final Point to;

    private int length;


    public Route(Point from, Point to, int length) {
        this.from = from;
        this.to = to;
        this.length = length;
    }

    public Point getFrom() {
        return from;
    }

    public Point getTo() {
        return to;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public int compareTo(Route o) {
        return length-o.getLength();
    }
}
