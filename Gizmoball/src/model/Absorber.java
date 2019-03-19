package model;

import physics.LineSegment;

import java.awt.*;
import java.util.ArrayList;

public class Absorber {

    private int xpos1, ypos1, ypos2, xpos2, gridX1, gridY1, gridX2, gridY2, width, height;
    private int initX, initY;
    private Color colour;

    // Walls are the enclosing Rectangle - defined by top left corner and bottom
    // right
    public Absorber(int grdX1, int grdY1, int grdX2, int grdY2) {
        colour = Color.MAGENTA;
        gridX1 = grdX1;
        gridY1 = grdY1;
        gridX2 = grdX2;
        gridY2 = grdY2;

        keepInBounds();

        xpos1 = gridX1*Model.L+50;
        ypos1 = gridY1*Model.L+50;
        xpos2 = gridX2*Model.L+50;
        ypos2 = gridY2*Model.L+50;

        initX = gridX1;
        initY = gridY1;

        width = gridX2 - gridX1;
        height = gridY2 - gridY1;
    }

    public ArrayList<LineSegment> getLineSegments() {
        ArrayList<LineSegment> ls = new ArrayList<>();
        LineSegment l1 = new LineSegment(xpos1, ypos1, xpos2 + Model.L, ypos1);
        LineSegment l2 = new LineSegment(xpos1, ypos1, xpos1, ypos2);
        LineSegment l3 = new LineSegment(xpos2 + Model.L, ypos1, xpos2 + Model.L, ypos2);
        LineSegment l4 = new LineSegment(xpos1, ypos2, xpos2 + Model.L, ypos2);
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

    public void setColour(Color colour){
        this.colour = colour;
    }

    public void setNewGridX(int x){
        if(x>initX){
            gridX1 = initX;
            gridX2 = x;
        }if(x< initX){
            gridX2 = initX;
            gridX1 = x;
        }if(x==initX){
            gridX2 = initX;
            gridX1 = initX;
        }
    }

    public void setNewGridY(int y){
        if(y>initY){
            gridY1 = initY;
            gridY2 = y;
        }if(y< initY){
            gridY2 = initY;
            gridY1 = y;
        }if(y==initY){
            gridY2 = initY;
            gridY1 = initY;
        }
    }

    public void updateXY(){

        keepInBounds();

        xpos1 = gridX1*Model.L+50;
        ypos1 = gridY1*Model.L+50;
        xpos2 = gridX2*Model.L+50;
        ypos2 = gridY2*Model.L+50;

        width = gridX2 - gridX1;
        height = gridY2 - gridY1;
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

    private void keepInBounds(){
        //kepp absorber in bounds
        if(gridX2 >19){
            gridX2 = 19;
        }if(gridY2 > 19){
            gridY2 = 19;
        }if(gridX1>19){
            gridX1 = 19;
        }if(gridY1>19){
            gridY1 = 19;
        }

        if(gridX2 <0){
            gridX2 = 0;
        }if(gridY2 < 0){
            gridY2 = 0;
        }if(gridX1<0){
            gridX1 = 0;
        }if(gridY1<0){
            gridY1 = 0;
        }

    }
}
