package model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GameLoader {

    public void loadGame(Model  model){

        try {
            Scanner read = new Scanner(new File("file.txt"));
            String type, id;
            int x, y, x2 = 0, y2 = 0, rotation = 0;
            double xVelo = 0, yVelo = 0;

            while (read.hasNextLine()) {
                type = read.next();
                if(type.equals("Gravity")){
                    model.setGravity(Float.parseFloat(read.next()));
                }else if(type.equals("Friction")){
                    model.setFriction(Float.parseFloat(read.next()), Float.parseFloat(read.next()));
                }else {
                    //We have a Gizmo
                    id = read.next();
                    x = Integer.parseInt(read.next());
                    y = Integer.parseInt(read.next());
                    if (type.equals("Square")) {
                        SquareGizmo sg = new SquareGizmo(x, y);
                        model.addGizmo(sg);
                    } else if (type.equals("Circle")) {
                        CircleGizmo cg = new CircleGizmo(x, y);
                        model.addGizmo(cg);
                    } else if (type.equals("Ball")) {
                        xVelo = Double.parseDouble(read.next());
                        yVelo = Double.parseDouble(read.next());
                        Ball ball = new Ball(x, y, xVelo, yVelo);
                        model.addBall(ball);
                    } else if (type.equals("Triangle")) {
                        rotation = Integer.parseInt(read.next());
                        TriangleGizmo tg = new TriangleGizmo(x, y);
                        model.addGizmo(tg);
                    } else if (type.equals("Absorber")) {
                        x2 = Integer.parseInt(read.next());
                        y2 = Integer.parseInt(read.next());
                        Absorber abs = new Absorber(x, y, x2, y2);
                        model.addGizmo(abs);
                    }
                    System.out.println(id + " " + x + " " + y + " " + rotation + "\n");
                }
            }
            read.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
