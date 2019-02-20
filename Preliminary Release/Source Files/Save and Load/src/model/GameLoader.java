package model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GameLoader {

    public void loadGame(Model  model){

        InputStream is = getClass().getResourceAsStream("/file.txt");
		Scanner read = new Scanner(is);
		//Scanner read = new Scanner(new File("/file.txt"));
		String type, id;
		int x, y, x2 = 0, y2 = 0, rotation = 0;
		Float bx, by;
		double xVelo = 0, yVelo = 0, angle;
		int L = 25;

		while (read.hasNextLine()) {
		    type = read.next();
		    if(type.equals("Gravity")){
		        model.setGravity(Float.parseFloat(read.next()));
		    }else if(type.equals("Friction")){
		        model.setFriction(Float.parseFloat(read.next()), Float.parseFloat(read.next()));
		    }else if(type.equals("Ball")) {
		    	//We have a Gizmo
		        id = read.next();
		        bx = Float.parseFloat(read.next()) * 25;
		        by = Float.parseFloat(read.next()) * 25;
		            xVelo = Double.parseDouble(read.next());
		            yVelo = Double.parseDouble(read.next());
		            Ball ball = new Ball(bx, by, xVelo, yVelo);
		            model.addBall(ball);
		    }
		    
		    else if (type.equals("Square") || type.equals("Triangle") || type.equals("Absorber") || type.equals("LeftFlipper") || type.equals("RightFlipper") || type.equals("Circle")){
		        //We have a Gizmo
		        id = read.next();
		        x = Integer.parseInt(read.next()) * L;
		        y = Integer.parseInt(read.next()) * L;
		        if (type.equals("Square")) {
		            SquareGizmo sg = new SquareGizmo(x, y);
		            model.addGizmo(sg);
		        } else if (type.equals("Circle")) {
		            CircleGizmo cg = new CircleGizmo(x, y);
		            model.addGizmo(cg);
		        } else if (type.equals("Triangle")) {
		            //rotation = Integer.parseInt(read.next());
		            TriangleGizmo tg = new TriangleGizmo(x, y);
		            int rotationCount = countRotations(id);
		            int i = 0;
		            while (i < rotationCount) {
						 tg.rotateClockwise();
						 i++;
					}
		            model.addGizmo(tg);
		        } else if (type.equals("Absorber")) {
		            x2 = Integer.parseInt(read.next()) * 25;
		            y2 = Integer.parseInt(read.next()) * 25;
		            Absorber abs = new Absorber(x, y, x2, y2);
		            model.addGizmo(abs);
		        } else if (type.equals("LeftFlipper")) {
		            LeftFlipperGizmo lf = new LeftFlipperGizmo(x, y, 0);
		            int rotationCount = countRotations(id);
		            int i = 0;
		            while (i < rotationCount) {
						 lf.rotateClockwise();
						 i++;
					}
		            model.addGizmo(lf);
		        } else if (type.equals("RightFlipper")) {
		            RightFlipperGizmo rf = new RightFlipperGizmo(x, y, 0);
		            int rotationCount = countRotations(id);
		            int i = 0;
		            while (i < rotationCount) {
						 rf.rotateClockwise();
						 i++;
					}
		            model.addGizmo(rf);
		        } 
		        System.out.println(id + " " + x + " " + y + " " + rotation + "\n");
		    } else {
		    	
		    }
		}
		read.close();
    }
    
    public int countRotations(String name) {
		int count = 0;
        InputStream is = getClass().getResourceAsStream("/file.txt");
		Scanner read = new Scanner(is);
		String type, id;
		int x, y, x2 = 0, y2 = 0, rotation = 0;
		Float bx, by;
		double xVelo = 0, yVelo = 0, angle;
		int L = 25;

		while (read.hasNextLine()) {
		    type = read.next();
		    if (type.equals("Rotate")){
		        id = read.next();
		        if (id.equals(name)) {
					count++;
				}
		    }
		}
		read.close();
		
    	return count;
    	
    }
}
