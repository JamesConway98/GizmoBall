package model;

import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Absorber {

    private int xpos1, ypos1, ypos2, xpos2, width, height;
    private Color colour;

    // Walls are the enclosing Rectangle - defined by top left corner and bottom
    // right
    public Absorber(int x1, int y1, int x2, int y2) {
        colour = Color.MAGENTA;
        xpos1 = x1;
        ypos1 = y1;
        xpos2 = x2;
        ypos2 = y2;

        width = x2 - x1;
        height = y2 - y1;
    }

    public ArrayList<LineSegment> getLineSegments() {
        ArrayList<LineSegment> ls = new ArrayList<>();
        LineSegment l1 = new LineSegment(xpos1, ypos1, xpos2, ypos1);
        LineSegment l2 = new LineSegment(xpos1, ypos1, xpos1, ypos2);
        LineSegment l3 = new LineSegment(xpos2, ypos1, xpos2, ypos2);
        LineSegment l4 = new LineSegment(xpos1, ypos2, xpos2, ypos2);
        ls.add(l1);
        ls.add(l2);
        ls.add(l3);
        ls.add(l4);
        return ls;
    }

    public int getXpos1() {
        return xpos1;
    }

    public int getYpos1() {
        return ypos1;
    }

    public int getXpos2() {
        return xpos2;
    }

    public int getYpos2() {
        return ypos2;
    }

    public Color getColour() {
        return colour;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
