package model.Gizmos;

import model.Model;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class RightFlipperGizmo implements Gizmo{
    private String ID;
    private int xpos, ypos, gridX, gridY;
    private int length = Model.L;
    private int rotation = 0;
    private Color colour;
    private char key;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();

    private boolean gizmoMoving = false;
    private boolean gizmoActive = false;
    private boolean toggle = true;

    public Vect v1, v2, v3, v4, v5, v6;
    private LineSegment e1, e2;
    private Circle c1, c2, c3, c4, c5, c6;
    private double angle;

    public RightFlipperGizmo(String id, int gridX, int gridY){
        this.gridX = gridX;
        this.gridY = gridY;
        ID = id;
        setColour(Color.CYAN);
        setAngle(0);
    }

    public String getID() {
        return ID;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public void setHitbox() {
        clearCollisions();
        double angle = Math.toRadians(-getAngle());
        double perpendicularAngle = Math.toRadians(-getAngle() - 90);
        int x = getX();
        int y = getY();
        int L = getLength();
        int r = getRotation();

        //Get location of first large Circle
        if (r == 0){
            v1 = new Vect(x + 1.75*L, y + 0.25*L);
        }
        if (r == 1){
            v1 = new Vect(x + 1.75*L, y + 1.75*L);
        }
        if (r == 2){
            v1 = new Vect(x + 0.25*L, y + 1.75*L);
        }
        if (r == 3){
            v1 = new Vect(x + 0.25*L, y + 0.25*L);
        }

        //Get location of second large circle
        double distX = 1.5 * L * Math.sin(angle);
        double distY = 1.5 * L * Math.cos(angle);
        if (r == 1){
            distX = 1.5 * L * Math.sin(perpendicularAngle);
            distY = 1.5 * L * Math.cos(perpendicularAngle);
        }
        if (r == 2){
            distX = -1.5 * L * Math.sin(angle);
            distY = -1.5 * L * Math.cos(angle);
        }
        if (r == 3){
            distX = -1.5 * L * Math.sin(perpendicularAngle);
            distY = -1.5 * L * Math.cos(perpendicularAngle);
        }

        v2 = new Vect(v1.x() + distX, v1.y() + distY);
        if (r == 0 || r == 2){
            distX = 0.25 * L * Math.sin(perpendicularAngle);
            distY = 0.25 * L * Math.cos(perpendicularAngle);
        }
        if (r == 1 || r == 3){
            distX = 0.25 * L * Math.sin(angle);
            distY = 0.25 * L * Math.cos(angle);
        }
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

        getEdges().add(e1);
        getEdges().add(e2);
        getVertices().add(c1);
        getVertices().add(c2);
        getVertices().add(c3);
        getVertices().add(c4);
        getVertices().add(c5);
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
        setRotation(((getRotation() + 1) + 4) % 4);
        setHitbox();
    }

    public void rotateAnticlockwise() {
        setRotation(((getRotation() - 1) + 4) % 4);
        setHitbox();
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle % 360;
        setHitbox();
    }

    public boolean isGizmoActive() { return gizmoActive; }

    public void setGizmoActive(boolean gizmoActive) { this.gizmoActive = gizmoActive; }

    public boolean isGizmoMoving() {
        return gizmoMoving;
    }

    public void setGizmoMoving(boolean gizmoIsMoving) {
        this.gizmoMoving = gizmoIsMoving;
    }

    public boolean getMoveToggle() {
        return toggle;
    }

    public void flipMoveToggle() {
        toggle = !toggle;
    }
}