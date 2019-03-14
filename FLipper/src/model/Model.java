package model;

import model.Gizmos.*;
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
	private float gravity, mu, mu2;

	private ArrayList<Absorber> abs;
	private static final double MU = 0.025;
	private static final double MU2 = 0.025;
	private static final int GRAVITY = 25;
	private static final int L = 25;

	private double speed;
	private double shortestTime;
	private double time = 0.0;
	private Vect newVelo = new Vect(0, 0);

	public Model() {
		// Ball position (25, 25) in pixels. Ball velocity (100, 100) pixels per tick
		ball = new Ball(25, 25, 100, 100);
		// Wall size 500 x 500 pixels
		gws = new Walls(0, 0, 500, 500);
		// Lines added in Main
		lines = new ArrayList<VerticalLine>();
		// Gizmos added in Main
		gizmos = new ArrayList<Gizmo>();
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
                //moveFlippers(moveTime);
			} else {
				// We've got a collision in tuc
				ball = movelBallForTime(ball, tuc);
				// Post collision velocity ...
				ball.setVelo(cd.getVelo());
				ball.stop();
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							Thread.sleep(400);
							ball.start();
						} catch(InterruptedException ex) {
							ex.printStackTrace();
						}
					}
				});
				t.start();
        	}
			if (tuc > moveTime) {
				moveFlippers(moveTime);
			} else {
				moveFlippers(tuc);
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
                    newVelo = Geometry.reflectWall(line, ball.getVelo(), 0);
                    if(time < 0.05) {
                        ball.stop();
						ball.setExactX(absorber.getXpos1() + absorber.getXpos2() -ball.getRadius());
						//TODO change yPos variables
						ball.setExactY(absorber.getYpos2() -ball.getRadius());
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
		//TODO change center maybe
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

    public double getSpeed() {
        return speed;
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

	public void addBall(Ball b) {
		ball = b;
	}

    public void addAbsorber(Absorber a) {
        abs.add(a);
    }

    public ArrayList<Absorber> getAbsorbers() {
        return abs;
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


	public void addGizmo(Gizmo g) { gizmos.add(g); }

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
}