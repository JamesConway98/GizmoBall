package model;

import model.Gizmos.*;

import java.io.*;
import java.util.ArrayList;

public class GameSaver {

    public void saveGizmos(ArrayList<Gizmo> gizmos){
        System.out.println("Saving...");
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("/file.txt", true), "utf-8"))) {

            int i = 0;

            clearSaveFile();

            for(Gizmo gizmo: gizmos){
                if(gizmo instanceof CircleGizmo) {
                    writer.append("\nCircle C" + i + " " + gizmo.getX() / 25 + " " + gizmo.getY() / 25);
                }else if(gizmo instanceof TriangleGizmo){
                    writer.append("\nTriangle T" + i + " " + gizmo.getX() / 25 + " " + gizmo.getY() / 25 + "");
                    int index = 0;
                    while (index < gizmo.getRotation()) {
						 writer.append("\nRotate T" + i + "");
						 index++;
					}
                }else if(gizmo instanceof SquareGizmo){
                    writer.append("\nSquare S" + i + " " + gizmo.getX() / 25 + " " + gizmo.getY() / 25);
                }else if(gizmo instanceof Absorber){
                    Absorber absorber = (Absorber)gizmo;
                    writer.append("\nAbsorber A" + i + " " + absorber.getXpos1() / 25 + " " + absorber.getYpos1() / 25
                            + " " + absorber.getXpos2() / 25 + " " + absorber.getYpos2() / 25);
                }else if(gizmo instanceof LeftFlipperGizmo){
                    writer.append("\nLeftFlipper LF" + i + " " + gizmo.getX() / 25 + " " + gizmo.getY() / 25);
                    int index = 0;
                    while (index < gizmo.getRotation()) {
						 writer.append("\nRotate LF" + i + "");
						 index++;
					}
                }else if(gizmo instanceof RightFlipperGizmo){
                    writer.append("\nRightFlipper RF" + i + " " + gizmo.getX() / 25 + " " + gizmo.getY() / 25);
                    int index = 0;
                    while (index < gizmo.getRotation()) {
						 writer.append("\nRotate RF" + i + "");
						 index++;
					}
                }
                i++;
            }

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveBall(Ball ball){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("/file.txt", true), "utf-8"))) {

        	double bx = ball.getExactX() / 25;
        	double by = ball.getExactY() / 25;
        	
            writer.append("\nBall B1 " + bx + " " + by +
                    " " + ball.getVelo().x() + " " + ball.getVelo().y());

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveGravity(Float grav){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("/file.txt", true), "utf-8"))) {

            writer.append("\nGravity " + grav);

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveFriction(Float mu, Float mu2){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("/file.txt", true), "utf-8"))) {

            writer.append("\nFriction " + mu + " " + mu2);

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void clearSaveFile(){
        System.out.println("Clearing Save File");
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("/file.txt"), "utf-8"))) {

            writer.write("");

        } catch(IOException io){
            io.printStackTrace();
        }
    }


}
