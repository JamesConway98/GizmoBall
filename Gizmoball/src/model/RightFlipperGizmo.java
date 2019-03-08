package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class RightFlipperGizmo implements Gizmo{
    private int xpos, ypos, gridX, gridY;
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

    public RightFlipperGizmo(int gridX, int gridY, double a){
        this.gridX = gridX;
        this.gridY = gridY;
        angle = a;
        setColour(Color.CYAN);
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

        //TODO Hitbox for Right FLipper, not required for JARs
    }


    public int getX() {
        return gridX*Model.L +50;
    }

    public int getY() {
        return gridY*Model.L +50;
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
