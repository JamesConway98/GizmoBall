package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class LeftFlipperGizmo implements Gizmo{
    private int xpos, ypos;
    private int length = Model.L;
    private int rotation = 0;
    private Color colour;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();
    private boolean gizmoMoving = true;


    private boolean gizmoActive = true;

    private ArrayList<LineSegment> movingEdgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> movingVertexList = new ArrayList<Circle>();


    public Vect v1, v2, v3, v4, v5, v6;
    private LineSegment e1, e2;
    private Circle c1, c2, c3, c4, c5, c6;


    private double angle;

    public LeftFlipperGizmo(int x, int y, double a){
        xpos = x;
        ypos = y;
        angle = a;
        setColour(Color.MAGENTA);
        setAngle(a);
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle % 360;
        setHitbox();
    }

    public void setHitbox() {
        clearCollisions();

        double angle = Math.toRadians(-getAngle());
        double perpendicularAngle = Math.toRadians(-getAngle() - 90);
        int x = getX();
        int y = getY();
        int L = getLength();

        //Get location of first large Circle
        v1 = new Vect(x + 0.25*L, y + 0.25*L);

        //Get location of second large circle
        double distX = 1.5 * L * Math.sin(angle);
        double distY = 1.5 * L * Math.cos(angle);
        v2 = new Vect(v1.x() + distX, v1.y() + distY);

        distX = 0.25 * L * Math.sin(perpendicularAngle);
        distY = 0.25 * L * Math.cos(perpendicularAngle);

        v3 = new Vect(v1.x() + distX, v1.y() + distY);
        v4 = new Vect(v1.x() - distX, v1.y() - distY);
        v5 = new Vect(v2.x() + distX, v2.y() + distY);
        v6 = new Vect(v2.x() - distX, v2.y() - distY);

        c1 = new Circle(v1, 0.25*L);
        c2 = new Circle(v2, 0.25*L);
        c3 = new Circle(v3, 0);
        c4 = new Circle(v4, 0);
        c5 = new Circle(v5, 0);
        c6 = new Circle(v6, 0);


        e1 = new LineSegment(v3, v5);
        e2 = new LineSegment(v4, v6);

        getEdges().add(e1);
        getEdges().add(e2);

        getVertices().add(c1);
        getVertices().add(c2);
        getVertices().add(c3);
        getVertices().add(c4);
        getVertices().add(c5);
        getVertices().add(c6);
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
        //TODO
    }

    public void rotateAnticlockwise() {
        //TODO
    }

    public boolean isGizmoMoving() {
        return gizmoMoving;
    }

    public void setGizmoMoving(boolean gizmoIsMoving) {
        this.gizmoMoving = gizmoIsMoving;
    }

    public boolean isGizmoActive() { return gizmoActive; }

    public void setGizmoActive(boolean gizmoActive) { this.gizmoActive = gizmoActive; }
}
