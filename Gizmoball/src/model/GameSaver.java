package model;

import model.Gizmos.*;

import java.io.*;
import java.util.ArrayList;

public class GameSaver {

    public void saveGizmos(ArrayList<Gizmo> gizmos, File file){

        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file, true), "utf-8"))) {

            int i = 0;

            clearSaveFile(file);

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

    public void saveAbsorbers(ArrayList<Absorber> absorbers, File file){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file, true), "utf-8"))) {

            for(int i = 0; i<absorbers.size(); i++) {
                writer.append("\nAbsorber A" + i + " " + absorbers.get(i).getGridX1() + " " + absorbers.get(i).getGridY1()
                        + " " + absorbers.get(i).getGridX2() + " " + absorbers.get(i).getGridY2());
            }

        } catch(IOException io){
            io.printStackTrace();
        }


    }

    public void saveBall(Ball ball, File file){
        if(ball == null)
            return;

        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file, true), "utf-8"))) {

        	double bx = ball.getGridX();
        	double by = ball.getGridY();
        	
            writer.append("\nBall B1 " + bx + " " + by +
                    " " + ball.getVelo().x() + " " + ball.getVelo().y());

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveGravity(Float grav, File file){

        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file, true), "utf-8"))) {

            writer.append("\nGravity " + grav);

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveFriction(Float mu, Float mu2, File file){

        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file, true), "utf-8"))) {

            writer.append("\nFriction " + mu + " " + mu2);

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void clearSaveFile(File file){

        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(file), "utf-8"))) {

            writer.write("");

        } catch(IOException io){
            io.printStackTrace();
        }
    }


}
