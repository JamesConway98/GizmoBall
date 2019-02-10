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

	private ArrayList<VerticalLine> lines;
	private Ball ball;
	private Walls gws;
	private ArrayList<Gizmo> gizmos;

	private double shortestTime;
	private double time = 0.0;
	Vect newVelo = new Vect(0, 0);

	public Model() {
		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
		ball = new Ball(25, 25, 100, 100);
		// Wall size 500 x 500 pixels
		gws = new Walls(0, 0, 500, 500);
		// Lines added in Main
		lines = new ArrayList<VerticalLine>();
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
		shortestTime = Double.MAX_VALUE;


		// Time to collide with 4 walls
		ArrayList<LineSegment> lss = gws.getLineSegments();
		for (LineSegment line : lss) {
			checkWallCollision(line, 1.0);
		}

		// Time to collide with any vertical lines
		for (VerticalLine line : lines) {
			LineSegment ls = line.getLineSeg();
			checkWallCollision(ls, 1.0);
		}

		// Time to collide with any gizmo
		for (Gizmo gizmo : gizmos) {
			if (gizmo instanceof SquareGizmo || gizmo instanceof TriangleGizmo || gizmo instanceof CircleGizmo) {
				ArrayList<LineSegment> lsList = gizmo.getEdges();
				for (int i = 0; i < lsList.size(); i++) {
					checkWallCollision(lsList.get(i), 1.0);
				}
				ArrayList<Circle> cList = gizmo.getVertices();
				for (int i = 0; i < cList.size(); i++) {
					checkCircleCollision(cList.get(i), 1.0);
				}
			} else if (gizmo instanceof LeftFlipperGizmo) {
				ArrayList<LineSegment> lsList = gizmo.getEdges();
				for (int i = 0; i < lsList.size(); i++) {
					checkWallCollision(lsList.get(i), 0.95);
				}
				ArrayList<Circle> cList = gizmo.getVertices();
				for (int i = 0; i < cList.size(); i++) {
					checkCircleCollision(cList.get(i), 0.95);
				}
			}
		}

		return new CollisionDetails(shortestTime, newVelo);
	}

	public boolean checkWallCollision(LineSegment lineSegment, double reflectionCoeff){
		// Now find shortest time to hit a vertical line or a wall line
		time = Geometry.timeUntilWallCollision(lineSegment, ball.getCircle(), ball.getVelo());
		if (time < shortestTime) {
			shortestTime = time;
			newVelo = Geometry.reflectWall(lineSegment, ball.getVelo(), reflectionCoeff);
			return true;
		}
		return false;
	}
	public boolean checkCircleCollision(Circle circle , double reflectionCoeff){
		// Now find shortest time to hit a vertical line or a wall line
		time = Geometry.timeUntilCircleCollision(circle, ball.getCircle(), ball.getVelo());
		if (time < shortestTime) {
			shortestTime = time;
			newVelo = Geometry.reflectCircle(circle.getCenter(), ball.getCircle().getCenter(), ball.getVelo(), reflectionCoeff);
			return true;
		}
		return false;
	}

	public Ball getBall() {
		return ball;
	}

	public ArrayList<VerticalLine> getLines() {
		return lines;
	}

	public ArrayList<Gizmo> getGizmos(){
		return gizmos;
	}

	public void addLine(VerticalLine l) {
		lines.add(l);
	}

	public void addGizmo(Gizmo g) { gizmos.add(g); }

	public void setBallSpeed(int x, int y) {
		ball.setVelo(new Vect(x, y));
	}


}