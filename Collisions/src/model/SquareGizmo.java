package model;

import java.awt.Color;
import java.util.ArrayList;

import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class SquareGizmo {
	private int xpos, ypos;
	private int length = 40;
	private Color colour;
	private Vect v1, v2, v3, v4;
	private LineSegment e1, e2, e3, e4;
	private ArrayList<LineSegment> edgeList = new ArrayList<LineSegment>();
	private ArrayList<Circle> vertexList = new ArrayList<Circle>();

	public SquareGizmo(int x, int y) {
		xpos = x;
		ypos = y;
		colour = Color.YELLOW;
		//Value for L
		int L = getLength();
		//Vertices, starting from top-left, then clockwise
		v1 = new Vect(x, y);
		v2 = new Vect(x + L, y);
		v3 = new Vect(x + L, y + L);
		v4 = new Vect(x, y + L);
		
		//Edges, starting from top, the clockwise
		e1 = new LineSegment(v1, v2);
		e2 = new LineSegment(v2, v3);
		e3 = new LineSegment(v3, v4);
		e4 = new LineSegment(v4, v1);
		edgeList.add(e1);
		edgeList.add(e2);
		edgeList.add(e3);
		edgeList.add(e4);
		
		//0 radius circles at each vertex
		Circle vc1 = new Circle(v1, 0);
		Circle vc2 = new Circle(v2, 0);
		Circle vc3 = new Circle(v3, 0);
		Circle vc4 = new Circle(v4, 0);
		vertexList.add(vc1);
		vertexList.add(vc2);
		vertexList.add(vc3);
		vertexList.add(vc4);
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

	public Color getColour() {
		return colour;
	}
}