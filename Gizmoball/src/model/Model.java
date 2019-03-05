package model;

import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {

	private Ball ball;
	private Walls gws;
	private ArrayList<Absorber> abs;

	private static final double MU = 0.025;
	private static final double MU2 = 0.025;
	private static final int GRAVITY = 25;
	public static final int L = 40;

	private double speed;
	private double shortestTime;
	private double time = 0.0;
	private Vect newVelo = new Vect(0, 0);
	private ArrayList<Gizmo> gizmos;
	private MouseListener activeMouseListener;

	public Model() {

		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
		ball = new Ball(500-6.25, 480-6.25, 0, 0);

		// Wall size 500 x 500 pixels
		gws = new Walls(0, 0, 500, 500);

		//Absorber added in Main
		abs = new ArrayList<>();

		// Gizmos added in Main
		gizmos = new ArrayList<Gizmo>();
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
				ball.setVelo(cd.getVelo());
				//Post collision velocity ...
			}

			//Apply friction and gravity
			double friction = 1 - (MU /moveTime) * moveTime - (MU2 /L) * Math.abs(ball.getVelo().length()) * moveTime;
			ball.setVelo(ball.getVelo().times(friction).plus(new Vect(0, GRAVITY*L*moveTime)));

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
						ball.setExactX(500-ball.getRadius());
						ball.setExactY(500-ball.getRadius());
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

	public void addGizmo(Gizmo g) {
		gizmos.add(g);
		setChanged();
		notifyObservers();
	}

	public ArrayList<Gizmo> getGizmos(){
		return gizmos;
	}

	public void addAbsorber(Absorber a) {
		abs.add(a);
		setChanged();
		notifyObservers();
	}

	public ArrayList<Absorber> getAbsorbers() {
		return abs;
	}

	public void rotateGizmo(Gizmo gizmo){
		gizmo.rotateClockwise();
		setChanged();
		notifyObservers();
	}

	public void setMouseListener(MouseListener ml){
		activeMouseListener = ml;
		setChanged();
		notifyObservers();
	}

	public MouseListener getActiveMouseListener() {
		return activeMouseListener;
	}
}
