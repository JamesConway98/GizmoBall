package model;

import physics.Circle;
import physics.Vect;

import java.awt.*;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Ball {

	private Vect velocity;
	private double speed;
	private double radius;
	private double xpos;
	private double ypos;
	private double previousXPos;
	private double previousYPos;
	private Color colour;

	private boolean stopped;

	// x, y coordinates and x,y velocity
	public Ball(double x, double y, double xv, double yv) {
		xpos = x; // Centre coordinates
		ypos = y;
		previousXPos = xpos;
		previousYPos = ypos;
		colour = Color.BLUE;
		velocity = new Vect(xv, yv);
		radius = 6.25;
		stopped = false;
		speed = velocity.length();
	}

	public Vect getVelo() {
		return velocity;
	}

	public void setVelo(Vect v) {
		velocity = v;
	}

	public double getRadius() {
		return radius;
	}

	public Circle getCircle() {
		return new Circle(xpos, ypos, radius);
	}

	public double updateSpeed() {
		speed = Math.round(Math.sqrt((ypos - previousYPos) * (ypos - previousYPos) + (xpos - previousXPos) * (xpos - previousXPos)));
		previousXPos = xpos;
		previousYPos = ypos;
		return speed;
	}

	// Ball specific methods that deal with double precision.
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
