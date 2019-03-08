package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class SquareGizmo implements Gizmo{
    private int xpos, ypos, gridX, gridY;
    private int length = Model.L;
    private int rotation = 0;
    private Color colour;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();

    private Vect v1, v2, v3, v4;
    private LineSegment e1, e2, e3, e4;
    private Circle c1, c2, c3, c4;

    public SquareGizmo(int gridX, int gridY){
        this.gridX = gridX;
        this.gridY = gridY;
        setColour(Color.YELLOW);
        setHitbox();
    }

    public void setHitbox() {
        clearCollisions();;
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

        //0 radius circles at each vertex
        c1 = new Circle(v1, 0);
        c2 = new Circle(v2, 0);
        c3 = new Circle(v3, 0);
        c4 = new Circle(v4, 0);
        getVertices().add(c1);
        getVertices().add(c2);
        getVertices().add(c3);
        getVertices().add(c4);
    }

    public int getX() {
        return gridX*Model.L+50;
    }

    public int getY() {
        return gridY*Model.L+50;
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