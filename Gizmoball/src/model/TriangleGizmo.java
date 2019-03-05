package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class TriangleGizmo implements Gizmo{
    private int xpos, ypos;
    private int length = Model.L;
    private int rotation = 0;
    private Color colour;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();

    private Vect v1, v2, v3, v4;
    private LineSegment e1, e2, e3;
    private Circle c1, c2, c3;

    public TriangleGizmo(int x, int y){
        xpos = x;
        ypos = y;
        setColour(Color.RED);
        setHitbox();
    }

    public void setHitbox() {
        clearCollisions();

        int x = getX();
        int y = getY();
        int L = getLength();
        int r = getRotation();
        v1 = new Vect(x, y);
        v2 = new Vect(x + L, y);
        v3 = new Vect(x, y + L);
        v4 = new Vect(x + L, y + L);
        if (r==0){
            //Edges, starting from top, the clockwise
            e1 = new LineSegment(v1, v2);
            e2 = new LineSegment(v2, v3);
            e3 = new LineSegment(v3, v1);

            c1 = new Circle(v1, 0);
            c2 = new Circle(v2, 0);
            c3 = new Circle(v3, 0);

        }   else if (r==1){
            e1 = new LineSegment(v1, v2);
            e2 = new LineSegment(v2, v4);
            e3 = new LineSegment(v4, v1);

            c1 = new Circle(v1, 0);
            c2 = new Circle(v2, 0);
            c3 = new Circle(v4, 0);

        }   else if (r==2){
            e1 = new LineSegment(v2, v3);
            e2 = new LineSegment(v3, v4);
            e3 = new LineSegment(v4, v2);

            c1 = new Circle(v2, 0);
            c2 = new Circle(v3, 0);
            c3 = new Circle(v4, 0);
        }   else if (r==3){
            e1 = new LineSegment(v1, v3);
            e2 = new LineSegment(v3, v4);
            e3 = new LineSegment(v4, v1);

            c1 = new Circle(v1, 0);
            c2 = new Circle(v3, 0);
            c3 = new Circle(v4, 0);
        }

        getEdges().add(e1);
        getEdges().add(e2);
        getEdges().add(e3);
        getVertices().add(c1);
        getVertices().add(c2);
        getVertices().add(c3);
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
        setRotation(((getRotation() + 1) + 4) % 4);
        setHitbox();
    }

    public void rotateAnticlockwise() {
        setRotation(((getRotation() + 1) - 4) % 4);
        setHitbox();
    }
}
