package model.Gizmos;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public interface Gizmo {
    public String getID();
    public char getKey();
    public void setKey(char key);
    public void setHitbox();
    public int getX();
    public int getY();
    public int getGridX();
    public int getGridY();
    public void setGridX(int gridX);
    public void setGridY(int gridY);
    public void setXpos(int x);
    public void setYpos(int y);
    public int getLength();
    public ArrayList<LineSegment> getEdges();
    public ArrayList<Circle> getVertices();
    public void clearCollisions();
    public Color getColour();
    public void setColour(Color colour);
    public int getRotation();
    public void setRotation(int rotation);
    public void rotateClockwise();
    public void rotateAnticlockwise();
    public boolean isGizmoActive();
    public void setGizmoActive(boolean gizmoActive);
}
