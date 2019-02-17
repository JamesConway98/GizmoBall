package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;

public class Absorber implements Gizmo {

    private int xpos1;
    private int ypos1;
    private int ypos2;
    private int xpos2;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();

    private Vect v1, v2, v3, v4;
    private LineSegment e1, e2, e3, e4;

    private Color colour;

    // Walls are the enclosing Rectangle - defined by top left corner and bottom
    // right
    public Absorber(int x1, int y1, int x2, int y2) {
        colour = Color.MAGENTA;
        xpos1 = x1;
        ypos1 = y1;
        xpos2 = x2;
        ypos2 = y2;
    }

    public int getXpos1() {
        return xpos1;
    }

    public int getYpos1() {
        return ypos1;
    }

    public int getXpos2() {
        return xpos2;
    }

    public int getYpos2() {
        return ypos2;
    }

    @Override
    public void setHitbox() {
        clearCollisions();
        int x = getX();
        int y = getY();
        int L = getLength();
        //Vertices, starting from top-left, then clockwise
        v1 = new Vect(x, y);
        v2 = new Vect(x + L, y);
        v3 = new Vect(x + L, y + L);
        v4 = new Vect(x, y + L);

        //Edges, starting from top, the clockwise
        e1 = new LineSegment(v1, v2);
        e2 = new LineSegment(v2, v3);
        e3 = new LineSegment(v3, v4);
        e4 = new LineSegment(v4, v1);
        getEdges().add(e1);
        getEdges().add(e2);
        getEdges().add(e3);
        getEdges().add(e4);
    }

    @Override
    public int getX() {
        return xpos1;
    }

    @Override
    public int getY() {
        return ypos1;
    }

    @Override
    public int getLength() {
        return xpos2 - xpos1;
    }

    @Override
    public ArrayList<LineSegment> getEdges() {
        return edgeList;
    }

    @Override
    public ArrayList<Circle> getVertices() {
        return vertexList;
    }

    @Override
    public void clearCollisions() {
        edgeList.clear();
        vertexList.clear();
    }

    public Color getColour() {
        return colour;
    }

    @Override
    public void setColour(Color colour) {

    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public void setRotation(int rotation) {

    }

    @Override
    public void rotateClockwise() {

    }

    @Override
    public void rotateAnticlockwise() {

    }
}
