package model;

import model.Gizmos.*;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {

	private ArrayList<VerticalLine> lines;
	private Ball ball;
	private Walls gws;
	private ArrayList<Gizmo> gizmos;
	private ArrayList<Absorber> abs;

	private float gravity, mu, mu2;
	private static final double MU = 0.025;
	private static final double MU2 = 0.025;
	private static final int GRAVITY = 25;
	public static final int L = 40;

	private double shortestTime;
	private double time = 0.0;
	private Vect newVelo = new Vect(0, 0);
	private GameLoader loader;
	private GameSaver saver;

	private MouseListener activeMouseListener;

	public Model() {

		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
		//ball = new Ball(500-6.25, 480-6.25, 0, 0);
		// Wall size 500 x 500 pixels
		//TODO change walls to match new L
		gws = new Walls(50, 50, (L*19) + 50, (L*19) + 50);
		// Lines added in Main
		lines = new ArrayList<>();
		// Gizmos added in Main
		gizmos = new ArrayList<>();
		//Absorber added in Main
		abs = new ArrayList<>();
		saver = new GameSaver();
		loader = new GameLoader();
	}

	public void moveBall() {
		double moveTime = 0.05; // 0.05 = 20 times per second as per Gizmoball
		if (ball != null && !ball.stopped()) {
			CollisionDetails cd = timeUntilCollision();
			double tuc = cd.getTuc();
			if (tuc > moveTime) {
				// No collision ...
				ball = movelBallForTime(ball, moveTime);
				//moveFlippers(moveTime);
			} else {
				// We've got a collision in tuc
				ball = movelBallForTime(ball, tuc);
				// Post collision velocity ...
				ball.setVelo(cd.getVelo());
			}
			if (tuc > moveTime) {
				moveFlippers(moveTime);
			} else {
				moveFlippers(tuc);
			}

			//Apply friction and gravity
			double friction = 1 - (MU /moveTime) * moveTime - (MU2 / L) * Math.abs(ball.getVelo().length()) * moveTime;
			ball.setVelo(ball.getVelo().times(friction).plus(new Vect(0, GRAVITY * L * moveTime)));


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
		return b;
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

		//Time to collide with any absorber
		for(Absorber absorber : abs) {
			ArrayList<LineSegment> lines = absorber.getLineSegments();
			for (LineSegment line : lines) {
				if(checkWallCollision(line, 0)) {
					if(time < 0.01) {
						ball.setExactY(ball.getExactY() + (ball.getRadius() * 2));
						ball.setExactX(absorber.getXpos2() + L - ball.getRadius());
						ball.stop();
					}
				}
			}
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
			} else if (gizmo instanceof Flipper) {
				if (((Flipper) gizmo).isGizmoMoving()){
					ArrayList<LineSegment> rlsList = ((Flipper) gizmo).getEdges();
					for (int i = 0; i < rlsList.size(); i++) {
						checkRotatingWallCollision(rlsList.get(i), 0.95);
					}
					ArrayList<Circle> rcList = ((Flipper) gizmo).getVertices();
					for (int i = 0; i < rcList.size(); i++) {
						checkRotatingCircleCollision(rcList.get(i), 0.95);
					}
				} else{
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

	public boolean checkRotatingWallCollision(LineSegment lineSegment, double reflectionCoeff){
		// Now find shortest time to hit a vertical line or a wall line
		time = Geometry.timeUntilRotatingWallCollision(lineSegment, lineSegment.p2(), 10.0, ball.getCircle(), ball.getVelo());
		if (time < shortestTime) {
			shortestTime = time;
			newVelo = Geometry.reflectRotatingWall(lineSegment, lineSegment.p2(), 10.0, ball.getCircle(), ball.getVelo(), reflectionCoeff);
			return true;
		}
		return false;
	}
	public boolean checkRotatingCircleCollision(Circle circle , double reflectionCoeff){
		// Now find shortest time to hit a vertical line or a wall line
		//we might need to change centre here
		time = Geometry.timeUntilRotatingCircleCollision(circle, circle.getCenter(), 10.0, ball.getCircle(), ball.getVelo());
		if (time < shortestTime) {
			shortestTime = time;
			newVelo = Geometry.reflectRotatingCircle(circle, circle.getCenter(), 10.0, ball.getCircle(), ball.getVelo(), reflectionCoeff);
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

	public void setGravity(float grav){
		gravity = grav;
	}

	public void setFriction(float mu1, float mu2){
		this.mu = mu1;
		this.mu2 = mu2;
	}

	public ArrayList<VerticalLine> getLines() {
		return lines;
	}

	public ArrayList<Gizmo> getGizmos(){
		return gizmos;
	}

	//Used for mapping triggers etc
	public int findGizmoIndex(String id){
		int index = 0;
		for (Gizmo gizmo : gizmos) {
			if (gizmo.getID() == id) {
				return index;
			}
			index++;
		}
		return 0;
	}

	public void addGizmo(Gizmo g) {
		clearGridSpace(g.getGridX(), g.getGridY());
		gizmos.add(g);
		setChanged();
		notifyObservers();
	}

	public void removeGizmo(Gizmo gizmo) {
		gizmos.remove(gizmo);
		setChanged();
		notifyObservers();
	}

	public void removeAbsorber(Absorber absorber){
		abs.remove(absorber);
	}

	public void clearGridSpace(int x, int y){
		Gizmo gizmoInBox = null;
		for(Gizmo gizmo: gizmos){
			if(gizmo.getGridX()==x && gizmo.getGridY()==y){
				gizmoInBox = gizmo;
			}
		}
		Absorber absorberInBox= null;
		for(Absorber absorber: abs){
			if(x>=absorber.getGridX1() && x<=absorber.getGridX2()){
				if(y>=absorber.getGridY1() && y<=absorber.getGridY2())
					absorberInBox = absorber;
			}
		}

		removeGizmo(gizmoInBox);
		removeAbsorber(absorberInBox);
	}



	public void addBall(Ball b) {
		ball = b;
		setChanged();
		notifyObservers();
	}

	public void addAbsorber(Absorber a) {
		abs.add(a);
		setChanged();
		notifyObservers();
	}

	public void clearAbsorbers() {
		abs.clear();
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

	public void moveFlippers(double time) {
		double moveTime = 0.05;
		for (Gizmo gizmo : gizmos) {
			if (gizmo instanceof LeftFlipperGizmo) {
				double ang = ((LeftFlipperGizmo) gizmo).getAngle();
				if (((LeftFlipperGizmo) gizmo).isGizmoActive() && ((LeftFlipperGizmo) gizmo).getMoveToggle()){
					((LeftFlipperGizmo) gizmo).setAngle(ang - (200 * moveTime));
					ang = ((LeftFlipperGizmo) gizmo).getAngle();
					((LeftFlipperGizmo) gizmo).setGizmoMoving(true);
					if (ang <= -90){
						((LeftFlipperGizmo) gizmo).flipMoveToggle();
						((LeftFlipperGizmo) gizmo).setGizmoMoving(false);
						gizmo.setGizmoActive(false);
						((LeftFlipperGizmo) gizmo).setAngle(-90);
					}
				} else if (((LeftFlipperGizmo) gizmo).isGizmoActive()){
					((LeftFlipperGizmo) gizmo).setAngle(ang + (200 * moveTime));
					ang = ((LeftFlipperGizmo) gizmo).getAngle();
					((LeftFlipperGizmo) gizmo).setGizmoMoving(true);
					if (ang >= 0){
						((LeftFlipperGizmo) gizmo).flipMoveToggle();
						((LeftFlipperGizmo) gizmo).setGizmoMoving(false);
						gizmo.setGizmoActive(false);
						((LeftFlipperGizmo) gizmo).setAngle(0);
					}
				}
			}

			if (gizmo instanceof RightFlipperGizmo) {
				double ang = ((RightFlipperGizmo) gizmo).getAngle();
				if (((RightFlipperGizmo) gizmo).isGizmoActive() && ((RightFlipperGizmo) gizmo).getMoveToggle()){
					((RightFlipperGizmo) gizmo).setAngle(ang + (200 * moveTime));
					ang = ((RightFlipperGizmo) gizmo).getAngle();
					((RightFlipperGizmo) gizmo).setGizmoMoving(true);
					if (ang >= 90){

						((RightFlipperGizmo) gizmo).flipMoveToggle();
						((RightFlipperGizmo) gizmo).setGizmoMoving(false);
						gizmo.setGizmoActive(false);
						((RightFlipperGizmo) gizmo).setAngle(90);
					}
				} else if (((RightFlipperGizmo) gizmo).isGizmoActive()){
					((RightFlipperGizmo) gizmo).setAngle(ang - (200 * moveTime));
					ang = ((RightFlipperGizmo) gizmo).getAngle();
					((RightFlipperGizmo) gizmo).setGizmoMoving(true);
					if (ang <= 0){
						((RightFlipperGizmo) gizmo).flipMoveToggle();
						((RightFlipperGizmo) gizmo).setGizmoMoving(false);
						gizmo.setGizmoActive(false);
						((RightFlipperGizmo) gizmo).setAngle(0);
					}
				}
			}
		}
	}

	public void saveGame(){
		GameSaver gs = new GameSaver();
		gs.saveGizmos(gizmos);
		gs.saveAbsorbers(abs);
		gs.saveBall(ball);
		gs.saveFriction(mu, mu2);
		gs.saveGravity(gravity);
	}

	public void loadGame(){
		GameLoader gl = new GameLoader();
		clearBoard();
		gl.loadGame(this);
		//this is needed to update the view
		setChanged();
		notifyObservers();
	}

	public void clearBoard(){
		gizmos.clear();
		ball = null;
	}

	public ArrayList<String> getGizmo(){
		ArrayList<String> a = new ArrayList<>();
		if (gizmos.size() == 0){
			return a;
		} else {
			for (Gizmo b : gizmos){
				if (b instanceof SquareGizmo) {
					a.add("SquareGizmo" + String.valueOf(b.getX()) + String.valueOf(b.getY()));
				} else if (b instanceof CircleGizmo) {
					a.add( "CircleGizmo" + String.valueOf(b.getX()) + String.valueOf(b.getY()));
				} else if (b instanceof TriangleGizmo) {
					a.add("TriangleGizmo" + String.valueOf(b.getX()) + String.valueOf(b.getY()));
				} else if (b instanceof  LeftFlipperGizmo){
					a.add("LeftFlipper" + String.valueOf(b.getX()) + String.valueOf(b.getY()));
				} else if (b instanceof  RightFlipperGizmo){
					a.add("RightFlipper" + String.valueOf(b.getX()) + String.valueOf(b.getY()));
				}
			}
			return a;
		}
	}


	public Walls getGws() {
		return gws;
	}
}
