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
                writer.write("\nSquare" + i + " " + squares.get(i).getX() + " " + squares.get(i).getY());
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
                writer.append("\nTriangle" + i + " " + triangles.get(i).getX() + " " + triangles.get(i).getY() + " " + triangles.get(i).getRotation());
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
                writer.append("\nCircle" + i + " " + circles.get(i).getX() + " " + circles.get(i).getY());
            }

        } catch(IOException io){
            io.printStackTrace();
        }
    }

    public void saveGame(){
        try (
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("file.txt"), "utf-8"))) {
                writer.write("something");
        } catch(IOException io){
            io.printStackTrace();
        }
    }


}
