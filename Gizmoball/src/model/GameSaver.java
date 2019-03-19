package model;

import model.Gizmos.*;

import javax.swing.*;
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
                String id;
                if(gizmo instanceof CircleGizmo) {
                    id = "C" + Integer.toString(i);
                    writer.append("\nCircle " + id + " " + gizmo.getGridX() + " " + gizmo.getGridY());
                    saveConnections(gizmo, id, writer);
                }else if(gizmo instanceof TriangleGizmo){
                    id = "T" + Integer.toString(i);
                    writer.append("\nTriangle " + id + " " + gizmo.getGridX() + " " + gizmo.getGridY() + "");

                    int index = 0;
                    while (index < gizmo.getRotation()) {
						 writer.append("\nRotate T" + i + "");
						 index++;
					}

					saveConnections(gizmo, id, writer);

                }else if(gizmo instanceof SquareGizmo){
                    id = "S" + Integer.toString(i);
                    writer.append("\nSquare " + id + " " + gizmo.getGridX() + " " + gizmo.getGridY());
                    saveConnections(gizmo, id, writer);

                }else if(gizmo instanceof LeftFlipperGizmo){
                    id = "LF" + Integer.toString(i);
                    writer.append("\nLeftFlipper " + id + " " + gizmo.getGridX()+ " " + gizmo.getGridY());
                    int index = 0;
                    while (index < gizmo.getRotation()) {
						 writer.append("\nRotate " + id + "");
						 index++;
					}
                    saveConnections(gizmo, id, writer);

                }else if(gizmo instanceof RightFlipperGizmo){
                    id = "RF" + Integer.toString(i);
                    writer.append("\nRightFlipper " + id + " " + gizmo.getGridX() + " " + gizmo.getGridY());
                    int index = 0;
                    while (index < gizmo.getRotation()) {
						 writer.append("\nRotate " + id + "");
						 index++;
					}
                    saveConnections(gizmo, id, writer);
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
                String id = "A" + Integer.toString(i);
                writer.append("\nAbsorber " + id + " " + absorbers.get(i).getGridX1() + " " + absorbers.get(i).getGridY1()
                        + " " + absorbers.get(i).getGridX2() + " " + absorbers.get(i).getGridY2());
                if (absorbers.get(i).getKey() != Character.MIN_VALUE) {
                    KeyStroke ks = KeyStroke.getKeyStroke(absorbers.get(i).getKey(), 0);
                    writer.append("\nKeyConnect key " + ks.getKeyCode() + " down " + id);
                }
            }

        } catch(IOException io){
            io.printStackTrace();
        }


    }

    public void saveConnections(Gizmo g, String id, Writer w) {
        try {
            if (g.getKey() != Character.MIN_VALUE) {
                KeyStroke ks = KeyStroke.getKeyStroke(g.getKey(), 0);
                w.append("\nKeyConnect key " + ks.getKeyCode() + " down " + id);
            }
            if (g.getConnection() != null) {
                w.append("\nConnect " + id + " " + g.getConnection());
            }
        } catch (IOException io) {
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
