package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;

public class TriangleGizmo extends Gizmo{
    private Vect v1, v2, v3, v4;
    private LineSegment e1, e2, e3;
    private Circle c1, c2, c3;

    public TriangleGizmo(int x, int y){
        super(x, y);
        setColour(Color.RED);
        //Value for L
        int L = getLength();
        int r = getRotation();
        //Vertices, starting from top-left, then clockwise
//        if (r==0){
//            v1 = new Vect(x, y + L);
//            v2 = new Vect(x, y);
//            v3 = new Vect(x + L, y);
//        }   else if (r==1){
//            v1 = new Vect(x, y);
//            v2 = new Vect(x + L, y);
//            v3 = new Vect(x + L, y + L);
//        }   else if (r==2){
//            v1 = new Vect(x + L, y);
//            v2 = new Vect(x + L, y + L);
//            v3 = new Vect(x, y + L);
//        }   else if (r==3){
//            v2 = new Vect(x + L, y + L);
//            v3 = new Vect(x, y + L);
//            v1 = new Vect(x, y);
//        }

        v1 = new Vect(x, y);
        v2 = new Vect(x + L, y);
        v3 = new Vect(x, y + L);
        v4 = new Vect(x + L, y + L);


        //Edges, starting from top, the clockwise
        e1 = new LineSegment(v1, v2);
        e2 = new LineSegment(v2, v3);
        e3 = new LineSegment(v3, v1);
        getEdges().add(e1);
        getEdges().add(e2);
        getEdges().add(e3);

        //0 radius circles at each vertex
        c1 = new Circle(v1, 0);
        c2 = new Circle(v2, 0);
        c3 = new Circle(v3, 0);
        getVertices().add(c1);
        getVertices().add(c2);
        getVertices().add(c3);
    }

    public void update(){
        getEdges().clear();
        getVertices().clear();
        int r = getRotation();
        //Vertices, starting from top-left, then clockwise
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

    public void rotateClockwise() {
        setRotation(((getRotation() + 1) + 4) % 4);
        update();
        System.out.println(getRotation());
    }

    public void rotateAnticlockwise() {
        setRotation(((getRotation() + 1) - 4) % 4);
        update();
    }

}
