package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;

public class SquareGizmo extends Gizmo{
    private Vect v1, v2, v3, v4;
    private LineSegment e1, e2, e3, e4;
    private Circle c1, c2, c3, c4;

    public SquareGizmo(int x, int y){
        super(x, y);
        setColour(Color.YELLOW);
        //Value for L
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

}
