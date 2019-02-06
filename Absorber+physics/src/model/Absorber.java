package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class Absorber {

    private int xpos1;
    private int ypos1;
    private int xpos2;
    private int ypos2;
    private Color colour;
    private Vect v1;
    private Vect v2;
    private Vect v3;
    private Vect v4;
    private LineSegment e1;
    private LineSegment e2;
    private LineSegment e3;
    private LineSegment e4;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();

    public Absorber(int x1, int y1, int x2, int y2) {
        xpos1 = x1;
        ypos1 = y1;
        xpos2 = x2;
        ypos2 = y2;
        colour = Color.MAGENTA;
        //Vertices, starting from top-left, then clockwise
        v1 = new Vect(x1, y1);
        v2 = new Vect(x2, y1);
        v3 = new Vect(x2, y2);
        v4 = new Vect(x1, y2);

        //Edges, starting from top, then clockwise
        e1 = new LineSegment(v1, v2);
        e2 = new LineSegment(v2, v3);
        e3 = new LineSegment(v3, v4);
        e4 = new LineSegment(v4, v1);
        edgeList.add(e1);
        edgeList.add(e2);
        edgeList.add(e3);
        edgeList.add(e4);

        //0 radius circles at each vertex
        Circle vc1 = new Circle(v1, 0);
        Circle vc2 = new Circle(v2, 0);
        Circle vc3 = new Circle(v3, 0);
        Circle vc4 = new Circle(v4, 0);
        vertexList.add(vc1);
        vertexList.add(vc2);
        vertexList.add(vc3);
        vertexList.add(vc4);
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

    public int getXpos1() { return xpos1; }

    public int getYpos1() { return ypos1; }

    public int getXpos2() { return xpos2; }

    public int getYpos2() { return ypos2; }
}
