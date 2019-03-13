package model;

import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Absorber {

    private int xpos1, ypos1, ypos2, xpos2, gridX1, gridY1, gridX2, gridY2, width, height;
    private Color colour;

    // Walls are the enclosing Rectangle - defined by top left corner and bottom
    // right
    public Absorber(int gridX1, int gridY1, int gridX2, int gridY2) {
        colour = Color.MAGENTA;
        this.gridX1 = gridX1;
        this.gridY1 = gridY1;
        this.gridX2 = gridX2;
        this.gridY2 = gridY2;
        this.xpos1 = gridX1*Model.L+50;
        this.ypos1 = gridY1*Model.L+50;
        this.xpos2 = gridX2*Model.L+50;
        this.ypos2 = gridY2*Model.L+50;

        width = gridX2 - gridX1;
        height = gridY2 - gridY1;
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

    public int getGridX1() {
        return gridX1;
    }

    public int getGridY1() {
        return gridY1;
    }

    public int getGridX2() {
        return gridX2;
    }

    public int getGridY2() {
        return gridY2;
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
