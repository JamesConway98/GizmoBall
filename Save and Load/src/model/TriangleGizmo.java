package model;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

import java.awt.*;
import java.util.ArrayList;

public class TriangleGizmo {
	
	private int xpos, ypos;
	private int length = 40;
	private Color colour;
	private Vect v1, v2, v3;
	private LineSegment e1, e2, e3;
	private int rotation;
	private int L;
	private Polygon outline;
	private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
	private ArrayList<Circle> vertexList = new ArrayList<Circle>();

	public TriangleGizmo(int x, int y, int rotation) {

		xpos = x;
		ypos = y;
		colour = Color.RED;
		//Value for L
		L = getLength();

		//rotation is how many times we rotate 90 degrees clockwise
		this.rotation = rotation;

		//Vertices, starting from top-left, then clockwise
		createVertices();
		
		//Edges
		e1 = new LineSegment(v1, v2);
		e2 = new LineSegment(v2, v3);
		e3 = new LineSegment(v3, v1);
		edgeList.add(e1);
		edgeList.add(e2);
		edgeList.add(e3);
		
		//0 radius circles at each vertex
		Circle vc1 = new Circle(v1, 0);
		Circle vc2 = new Circle(v2, 0);
		Circle vc3 = new Circle(v3, 0);

		vertexList.add(vc1);
		vertexList.add(vc2);
		vertexList.add(vc3);
	}

	public void createVertices(){

		v1 = new Vect(xpos, ypos);
		v2 = new Vect(xpos + L, ypos);
		v3 = new Vect(xpos, ypos + L);
		//if rotation then we switch one vertex for another
		if(rotation == 2){
			v3 = new Vect(xpos + L, ypos + L);
		}else if(rotation == 3){
			v1 = new Vect(xpos + L, ypos + L);
		}else if(rotation == 4){
			v2 = new Vect(xpos + L, ypos + L);
		}

		outline = new Polygon();

		outline.addPoint((int)v1.x(), (int)v1.y());
		outline.addPoint((int)v2.x(), (int)v2.y());
		outline.addPoint((int)v3.x(), (int)v3.y());

	}

	public void rotate(){
		rotation += 1;
	}

	public int getX() {
		return xpos;
	}

	public int getY() {
		return ypos;
	}

	public int getRotation(){
		return rotation;
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

	public Polygon getOutline() {
		return outline;
	}

	public Color getColour() {
		return colour;
	}
}