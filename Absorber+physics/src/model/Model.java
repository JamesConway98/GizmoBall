package model;

import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Model extends Observable {

	private Ball ball;
	private Walls gws;
	private ArrayList<Absorber> abs;

	private double shortestTime;
	private double time = 0.0;
	Vect newVelo = new Vect(0, 0);

	public Model() {

		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
		ball = new Ball(25, 25, 100, 100);

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
			} else {
				// We've got a collision in tuc
				ball = movelBallForTime(ball, tuc);
				// Post collision velocity ...
				ball.setVelo(cd.getVelo());
			}

			// Notify observers ... redraw updated view
			this.setChanged();
			this.notifyObservers();
		}

	}

	private Ball movelBallForTime(Ball ball, double time) {

		double newX = 0.0;
		double newY = 0.0;
		double xVel = ball.getVelo().x();
		double yVel = ball.getVelo().y();
		newX = ball.getExactX() + (xVel * time);
		newY = ball.getExactY() + (yVel * time);
		ball.setExactX(newX);
		ball.setExactY(newY);
		return ball;
	}

	private CollisionDetails timeUntilCollision() {
		// Find Time Until Collision and also, if there is a collision, the new speed vector.
		// Create a physics.Circle from Ball
		newVelo = new Vect(0, 0);

		// Now find shortest time to hit a vertical line or a wall line
		shortestTime = Double.MAX_VALUE;

		// Time to collide with 4 walls
		ArrayList<LineSegment> lss = gws.getLineSegments();
		for (LineSegment wall : lss) {
			if(checkWallCollision(wall)) {
				newVelo = Geometry.reflectWall(wall, ball.getVelo(), 1.0);
				System.out.println("Hit wall");
			}
		}

		//Time to collide with any absorber
		for(Absorber absorber : abs) {
			ArrayList<LineSegment> lines = absorber.getLineSegments();
			for (LineSegment line : lines) {
				if(checkWallCollision(line)) {
//					ball.setExactX(250);
//					ball.setExactY(0);
//					newVelo = Geometry.reflectWall(line, ball.getVelo(), 1.0);
					System.out.println("Hit absorber");
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
	public boolean checkCircleCollision(Circle circle){
		// Now find shortest time to hit a vertical line or a wall line
		time = Geometry.timeUntilCircleCollision(circle, ball.getCircle(), ball.getVelo());
		if (time < shortestTime) {
			shortestTime = time;
			return true;
		}
		return false;
	}

	public Ball getBall() {
		return ball;
	}
	
	public void setBallSpeed(int x, int y) {
		ball.setVelo(new Vect(x, y));
	}

	public void addAbsorber(Absorber a) { abs.add(a); }

	public ArrayList<Absorber> getAbsorbers() { return abs; }
}
