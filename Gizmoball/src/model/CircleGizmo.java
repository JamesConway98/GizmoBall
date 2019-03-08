package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class CircleGizmo implements Gizmo {
    private int xpos, ypos, gridX, gridY;
    private int length = Model.L;
    private int rotation = 0;
    private Color colour;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();

    private Vect v1;
    private Circle c1;


    public CircleGizmo(int gridX, int gridY){
        this.gridX = gridX;
        this.gridY = gridY;
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
        return gridX*Model.L+50;
    }

    public int getY() {
        return gridY *Model.L+50;
    }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
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