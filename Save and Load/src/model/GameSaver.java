package model;

import java.io.*;
import java.util.ArrayList;

public class GameSaver {

    public void saveGizmos(ArrayList<Gizmo> gizmos){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

            int i = 0;

            clearSaveFile();

            for(Gizmo gizmo: gizmos){
                if(gizmo instanceof CircleGizmo) {
                    writer.append("\nCircle C" + i + " " + gizmo.getX() + " " + gizmo.getY());
                }else if(gizmo instanceof TriangleGizmo){
                    writer.append("\nTriangle T" + i + " " + gizmo.getX() + " " + gizmo.getY() + " " + gizmo.getRotation());
                }else if(gizmo instanceof SquareGizmo){
                    writer.append("\nSquare S" + i + " " + gizmo.getX() + " " + gizmo.getY());
                }else if(gizmo instanceof Absorber){
                    Absorber absorber = (Absorber)gizmo;
                    writer.append("\nAbsorber A" + i + " " + absorber.getXpos1() + " " + absorber.getYpos1()
                            + " " + absorber.getXpos2() + " " + absorber.getYpos2());
                }
            }

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveBall(Ball ball){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

            writer.append("\nBall B1 " + (int)ball.getExactX() + " " + (int)ball.getExactY() +
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
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt"), "utf-8"))) {

            writer.write("");

        } catch(IOException io){
            io.printStackTrace();
        }
    }


}
