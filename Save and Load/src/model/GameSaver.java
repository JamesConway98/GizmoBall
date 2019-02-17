package model;

import java.io.*;
import java.util.ArrayList;

public class GameSaver {

    //for each item on board, save their x and y.
    // Could maybe use Gizmo interface as an argument to pass in all types at once
    public void saveSquareGizmos(ArrayList<SquareGizmo> squares){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt"), "utf-8"))) {

            for(int i = 0; i < squares.size(); i++){
                writer.write("\nSquare S" + i + " " + squares.get(i).getX() + " " + squares.get(i).getY());
            }

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveTriangleGizmos(ArrayList<TriangleGizmo> triangles){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

            for(int i = 0; i < triangles.size(); i++){
                writer.append("\nTriangle T" + i + " " + triangles.get(i).getX() + " " + triangles.get(i).getY() + " " + triangles.get(i).getRotation());
            }

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveCircleGizmos(ArrayList<CircularGizmo> circles){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

            for(int i = 0; i < circles.size(); i++){
                writer.append("\nCircle C" + i + " " + circles.get(i).getX() + " " + circles.get(i).getY());
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

    public void saveAbsorbers(ArrayList<Absorber> absorbers){
        try (
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("file.txt", true), "utf-8"))) {

            for(int i = 0; i < absorbers.size(); i++) {
                writer.append("\nAbsorber A" + i + " " + absorbers.get(i).getXpos1() + " " + absorbers.get(i).getYpos1()
                        + " " + absorbers.get(i).getXpos2() + " " + absorbers.get(i).getYpos2());
            }

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


}
