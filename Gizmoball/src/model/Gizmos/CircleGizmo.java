package model.Gizmos;

import model.Model;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class CircleGizmo implements Gizmo {
    private String ID;
    private int xpos, ypos, gridX, gridY;
    private int length = Model.L;
    private int rotation = 0;
    private Color colour;
    private char key;
    private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
    private ArrayList<Circle> vertexList = new ArrayList<Circle>();
    private boolean gizmoActive = false;

    private Vect v1;
    private Circle c1;

    private String connectionId = null;

    public CircleGizmo(String id, int gridX, int gridY){
        ID = id;
        this.gridX = gridX;
        this.gridY = gridY;
        setColour(Color.GREEN);
        setHitbox();
    }

    public String getID() {
        return ID;
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
        return (gridX*Model.L) + 50;
    }

    public int getY() { return (gridY *Model.L)+50; }

    public int getGridX() {
        return gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY;
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

    public void toggleColour() {
        if (getColour() == Color.GREEN){
            setColour(Color.RED);
        }
        else if (getColour() == Color.RED){
            setColour(Color.GREEN);
        }
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

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public boolean isGizmoActive() {
        return gizmoActive;
    }

    public void setGizmoActive(boolean gizmoActive) {
        this.gizmoActive = gizmoActive;
    }

    public void setConnection(String id) {
        connectionId = id;
    }

    public String getConnection() {
        return connectionId;
    }
}