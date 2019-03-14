package model;

import model.Gizmos.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameSaver {

    public void saveGizmos(ArrayList<Gizmo> gizmos){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

            int i = 0;

            clearSaveFile();

            for(Gizmo gizmo: gizmos){
                if(gizmo instanceof CircleGizmo) {
                    writer.append("\nCircle C" + i + " " + gizmo.getGridX() + " " + gizmo.getGridY());
                }else if(gizmo instanceof TriangleGizmo){
                    writer.append("\nTriangle T" + i + " " + gizmo.getGridX() + " " + gizmo.getGridY() + "");
                    int index = 0;
                    while (index < gizmo.getRotation()) {
						 writer.append("\nRotate T" + i + "");
						 index++;
					}
                }else if(gizmo instanceof SquareGizmo){
                    writer.append("\nSquare S" + i + " " + gizmo.getGridX() + " " + gizmo.getGridY());
                }else if(gizmo instanceof LeftFlipperGizmo){
                    writer.append("\nLeftFlipper LF" + i + " " + gizmo.getGridX()+ " " + gizmo.getGridY());
                    int index = 0;
                    while (index < gizmo.getRotation()) {
						 writer.append("\nRotate LF" + i + "");
						 index++;
					}
                }else if(gizmo instanceof RightFlipperGizmo){
                    writer.append("\nRightFlipper RF" + i + " " + gizmo.getGridX() + " " + gizmo.getGridY());
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
        if(ball == null)
            return;
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

        	double bx = ball.getGridX();
        	double by = ball.getGridY();
        	
            writer.append("\nBall B1 " + bx + " " + by +
                    " " + ball.getVelo().x() + " " + ball.getVelo().y());

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveGravity(Float grav){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

            writer.append("\nGravity " + grav);

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveFriction(Float mu, Float mu2){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

            writer.append("\nFriction " + mu + " " + mu2);

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void clearSaveFile(){
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("file.txt"), "utf-8"));

            writer.write("");

        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    public void saveAbsorbers(List<Absorber> absorbers) {
        try (
            Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("file.txt", true), "utf-8"))) {

            for(int i = 0; i < absorbers.size(); i++) {
                System.out.println(absorbers.size());
                Absorber absorber = absorbers.get(i);
                writer.append("\nAbsorber A" + i + " " + absorber.getGridX1() + " " + absorber.getGridY1()
                        + " " + absorber.getGridX2() + " " + absorber.getGridY2());
            }

        } catch(IOException io){
            io.printStackTrace();
        }
    }
}
