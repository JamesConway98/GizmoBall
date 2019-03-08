package model;

import physics.Circle;
import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public interface Gizmo {
    public void setHitbox();
    public int getX();
    public int getY();
    public int getGridX();
    public int getGridY();
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


}
