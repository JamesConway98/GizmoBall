package model;
import java.awt.Color;
import physics.Circle;
import physics.Vect;

public class CircularGizmo {
	private int xpos;
	private int ypos;
	private int length = 40;
	private Color colour;
	private Circle c;

	public CircularGizmo(int x, int y) {
		xpos = x;
		ypos = y;
		colour = Color.GREEN;
		//Value for L
		int L = getLength();
		Vect v1 = new Vect(x + L/2, y + L/2);
		c = new Circle(v1, L/2);
	}

	public Circle getCircle() {
		return c;
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
	
	public Color getColour() {
		return colour;
	}


}