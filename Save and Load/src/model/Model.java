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
	private ArrayList<SquareGizmo> squares;
	private ArrayList<CircularGizmo> circulars;
	private ArrayList<TriangleGizmo> triangles;

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
		// Squares added in Main
		squares = new ArrayList<SquareGizmo>();
		// Circles added in Main
		circulars = new ArrayList<CircularGizmo>();
		// Triangles added in Main
		triangles = new ArrayList<TriangleGizmo>();
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
			checkWallCollision(line);
		}

		// Time to collide with any vertical lines
		for (VerticalLine line : lines) {
			LineSegment ls = line.getLineSeg();
			checkWallCollision(ls);
		}

		// Time to collide with any square gizmo
		for (SquareGizmo square : squares) {
			ArrayList<LineSegment> lsList = square.getEdges();
			for(int i = 0; i < lsList.size(); i++) {
				checkWallCollision(lsList.get(i));
			}
			ArrayList<Circle> cList = square.getVertices();
			for(int i=0 ;i < cList.size(); i++) {
				checkCircleCollision(cList.get(i));
			}
		}
		// Time to collide with any circular gizmo
		for (CircularGizmo circle : circulars) {
			checkCircleCollision(circle.getCircle());
		}

		// Time to collide with any triangle gizmo
		for (TriangleGizmo triangle : triangles) {
			ArrayList<LineSegment> lsList = triangle.getEdges();
			for(int i =0; i < lsList.size(); i++) {
				checkWallCollision(lsList.get(i));
			}
			ArrayList<Circle> cList = triangle.getVertices();
			for(int i=0; i < cList.size(); i++) {
				checkCircleCollision(cList.get(i));
			}
		}
		return new CollisionDetails(shortestTime, newVelo);
	}

	public boolean checkWallCollision(LineSegment lineSegment){
		// Now find shortest time to hit a vertical line or a wall line
		time = Geometry.timeUntilWallCollision(lineSegment, ball.getCircle(), ball.getVelo());
		if (time < shortestTime) {
			shortestTime = time;
			newVelo = Geometry.reflectWall(lineSegment, ball.getVelo(), 1.0);
			return true;
		}
		return false;
	}
	public boolean checkCircleCollision(Circle circle){
		// Now find shortest time to hit a vertical line or a wall line
		time = Geometry.timeUntilCircleCollision(circle, ball.getCircle(), ball.getVelo());
		if (time < shortestTime) {
			shortestTime = time;
			newVelo = Geometry.reflectCircle(circle.getCenter(), ball.getCircle().getCenter(), ball.getVelo(), 1.0);
			return true;
		}
		return false;
	}

	public void saveGame(){
		GameSaver gs = new GameSaver();
		gs.saveSquareGizmos(squares);
		gs.saveTriangleGizmos(triangles);
	}

	public void loadGame(){
		GameLoader gl = new GameLoader();
		clearBoard();
		gl.loadGame(this);
		//this is needed to update the view
		this.setChanged();
		this.notifyObservers();
	}

	public Ball getBall() {
		return ball;
	}

	public ArrayList<VerticalLine> getLines() {
		return lines;
	}
	
	public ArrayList<SquareGizmo> getSquares(){
		return squares;
	} 
	
	public ArrayList<CircularGizmo> getCirculars(){
		return circulars;
	}
	
	public ArrayList<TriangleGizmo> getTriangles(){
		return triangles;
	}

	public void addLine(VerticalLine l) {
		lines.add(l);
	}
	
	public void setBallSpeed(int x, int y) {
		ball.setVelo(new Vect(x, y));
	}

	public void addSquare(SquareGizmo s) {
		squares.add(s);
	}
	
	public void addCircular(CircularGizmo c) {
		circulars.add(c);
	}
	
	public void addTriangle(TriangleGizmo t) {
		triangles.add(t);
	}

	public void clearBoard(){
		circulars.clear();
		squares.clear();
		triangles.clear();
	}
}
