package model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GameLoader {

    public void loadGame(Model  model){

        try {
            Scanner read = new Scanner(new File("file.txt"));
            String id;
            int x, y, rotation = 0;

            while (read.hasNextLine()) {
                id = read.next();
                x = Integer.parseInt(read.next());
                y = Integer.parseInt(read.next());
                if(id.contains("Square")) {
                    SquareGizmo sg = new SquareGizmo(x, y);
                    model.addSquare(sg);
                }else if(id.contains("Triangle")) {
                    rotation = Integer.parseInt(read.next());
                    TriangleGizmo tg = new TriangleGizmo(x, y, rotation);
                    model.addTriangle(tg);
                }
                System.out.println(id + " " + x + " " + y + " " + rotation + "\n");
            }
            read.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
