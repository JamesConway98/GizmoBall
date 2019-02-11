package model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Gizmo {

    private int xpos, ypos;
    private int length = 50;
    private int rotation = 0;
    private Color colour;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();

    public Gizmo(int x, int y){
        xpos = x;
        ypos = y;
        colour = Color.BLUE;
    }

    public int getX() {
        return xpos;
    }

    public int getY() {
        return ypos;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getRotation() { return rotation; }

    public int getLength() {
        return length;
    }

    public ArrayList<LineSegment> getEdges() {
        return edgeList;
    }

    public ArrayList<Circle> getVertices() {
        return vertexList;
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

}
