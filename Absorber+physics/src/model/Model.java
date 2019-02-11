package model;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Vector;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Model extends Observable {

	private Ball ball;
	private Walls gws;
	private ArrayList<Absorber> abs;
	private double speed;
	private static final double mu = 0.025;
	private static final double mu2 = 0.025;
	private static final int gravity = 25;

	private static final int L = 25;
	private double shortestTime;
	private double time = 0.0;
	private Vect newVelo = new Vect(0, 0);

	public Model() {

		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
		ball = new Ball(500-6.25, 480-6.25, 0, 0);

		// Wall size 500 x 500 pixels
		gws = new Walls(0, 0, 500, 500);

		//Absorber added in Main
		abs = new ArrayList<>();
	}

	public void moveBall() {

		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball
		if (ball != null && !ball.stopped()) {
			CollisionDetails cd = timeUntilCollision();
			double tuc = cd.getTuc();
			if (tuc > moveTime) {
				// No collision ...
				ball = movelBallForTime(ball, moveTime);
				double friction = 1 - (mu/moveTime) * moveTime - (mu2/L) * Math.abs(ball.getVelo().length()) * moveTime;
				ball.setVelo(ball.getVelo().times(friction).plus(new Vect(0, gravity*L*moveTime)));
			} else {
				// We've got a collision in tuc
				ball = movelBallForTime(ball, tuc);
				ball.setVelo(cd.getVelo());
				//Post collision velocity ...
				double friction = 1 - (mu/tuc) * tuc - (mu2/L) * Math.abs(ball.getVelo().length()) * tuc;
				ball.setVelo(ball.getVelo().times(friction).plus(new Vect(0, gravity*L*tuc)));
			}

			// Notify observers ... redraw updated view
			this.setChanged();
			this.notifyObservers();
		}
	}

	private Ball movelBallForTime(Ball b, double time) {
		double newX;
		double newY;
		double xVel = b.getVelo().x();
		double yVel = b.getVelo().y();
		newX = b.getExactX() + (xVel * time);
		newY = b.getExactY() + (yVel * time);
		b.setExactY(newY);
		b.setExactX(newX);
		speed = b.updateSpeed();
		return b;
	}

	private CollisionDetails timeUntilCollision() {
		// Find Time Until Collision and also, if there is a collision, the new speed vector.
		// Create a physics.Circle from Ball

		// Now find shortest time to hit a vertical line or a wall line
		shortestTime = Double.MAX_VALUE;

		// Time to collide with 4 walls
		ArrayList<LineSegment> lss = gws.getLineSegments();
		for (LineSegment wall : lss) {
			if(checkWallCollision(wall)) {
				newVelo = Geometry.reflectWall(wall, ball.getVelo(), 1.0);
			}
		}

		//Time to collide with any absorber
		for(Absorber absorber : abs) {
			ArrayList<LineSegment> lines = absorber.getLineSegments();
			for (LineSegment line : lines) {
				if(checkWallCollision(line)) {
					newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
					if(time < 0.05) {
						ball.stop();
					}
				}
			}
		}

		return new CollisionDetails(shortestTime, newVelo);
	}

	public boolean checkWallCollision(LineSegment lineSegment){
		// Now find shortest time to hit a vertical line or a wall line
		time = Geometry.timeUntilWallCollision(lineSegment, ball.getCircle(), ball.getVelo());
		if (time < shortestTime) {
			shortestTime = time;
			return true;
		}
		return false;
	}

	public Ball getBall() {
		return ball;
	}

	public double getSpeed() {
		return speed;
	}
	
	public void setBallSpeed(int x, int y) {
		ball.setVelo(new Vect(x, y));
	}

	public void addAbsorber(Absorber a) { abs.add(a); }

	public ArrayList<Absorber> getAbsorbers() { return abs; }
}
