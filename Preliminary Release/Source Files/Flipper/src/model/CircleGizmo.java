package model;
import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class CircleGizmo implements Gizmo {
    private int xpos, ypos;
    private int length = 25;
    private int rotation = 0;
    private Color colour;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();

    private Vect v1;
    private Circle c1;


    public CircleGizmo(int x, int y){
        xpos = x;
        ypos = y;
        setColour(Color.GREEN);
        setHitbox();
    }

    public void setHitbox() {
        clearCollisions();

        int x = getX();
        int y = getY();
        int L = getLength();

        v1 = new Vect(x + L/2, y + L/2);

        c1 = new Circle(v1, L/2);

        getVertices().add(c1);
    }

    public int getX() {
        return xpos;
    }

    public int getY() {
        return ypos;
    }

    public int getLength() {
        return length;
    }



    public ArrayList<LineSegment> getEdges() {
        return edgeList;
    }

    public ArrayList<Circle> getVertices() {
        return vertexList;
    }

    public void clearCollisions() {
        edgeList.clear();
        vertexList.clear();
    }

    public Color getColour() {
        return colour;
    }

    public void setColour(Color colour) {
        this.colour = colour;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int r) {
        rotation = r;
    }

    public void rotateClockwise() {
    }

    public void rotateAnticlockwise() {
    }
}