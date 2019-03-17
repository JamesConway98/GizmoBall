package model;

import physics.Circle;
import physics.Vect;

import java.awt.*;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Ball {

	private Vect velocity;
	public static final double R = 10;
	private double xpos;
	private double ypos;
	private int gridX, gridY;
	private Color colour;

	private boolean stopped;

	// x, y coordinates and x,y velocity
	public Ball(double x, double y, double xv, double yv) {

		xpos = x;
		ypos = y;
		gridX = (int)(x / Model.L - 50 - (R*2));
		gridY = (int)(y / Model.L - 50 - (R*2));
		/*gridX = (int)x;
		gridY = (int)y;
		xpos = x * Model.L + 50 + (R*2); // Centre coordinates
		ypos = y * Model.L + 50 + (R*2);*/
		colour = Color.BLUE;
		velocity = new Vect(xv, yv);
		stopped = false;
	}

	public Vect getVelo() {
		return velocity;
	}

	public void setVelo(Vect v) {
		velocity = v;
	}

	public double getRadius() {
		return R;
	}

	public Circle getCircle() {
		return new Circle(xpos, ypos, R);
	}

	public double getExactX() {
		return xpos;
	}

	public double getExactY() {
		return ypos;
	}

	public void setExactX(double x) {
		xpos = x;
	}

	public void setExactY(double y) {
		ypos = y;
	}

	public int getGridX() {
		return gridX;
	}

	public int getGridY() {
		return gridY;
	}

	public void stop() {
		stopped = true;
	}

	public void start() {
		stopped = false;
	}

	public boolean stopped() {
		return stopped;
	}

	public Color getColour() {
		return colour;
	}

}
