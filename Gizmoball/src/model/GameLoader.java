package model;

import model.Gizmos.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class GameLoader {

    public void loadGame(Model model, File file) {

        InputStream is = getClass().getResourceAsStream(file.getName());
		//Scanner read = new Scanner(is);
		try {
            Scanner read = new Scanner(file);
			String type, id, id2;
			int x, y, x2 = 0, y2 = 0, rotation = 0;
			Float bx, by;
			double xVelo = 0, yVelo = 0, angle;
			int L = Model.L;

			model.clearAbsorbers();

			while (read.hasNextLine()) {
				type = read.next();
				if (type.equals("Gravity")) {
					model.setGravity(Float.parseFloat(read.next()));
				} else if (type.equals("Friction")) {
					model.setFriction(Float.parseFloat(read.next()), Float.parseFloat(read.next()));
				} else if (type.equals("Ball")) {
					//We have a Gizmo
					id = read.next();
					bx = Float.parseFloat(read.next());
					by = Float.parseFloat(read.next());
					xVelo = Double.parseDouble(read.next());
					yVelo = Double.parseDouble(read.next());
					Ball ball = new Ball(bx, by, xVelo, yVelo);
					model.addBall(ball);
				} else if (type.equals("Square") || type.equals("Triangle") || type.equals("Absorber") || type.equals("LeftFlipper") || type.equals("RightFlipper") || type.equals("Circle")) {
					//We have a Gizmo
					id = read.next();
					x = Integer.parseInt(read.next());
					y = Integer.parseInt(read.next());
					if (type.equals("Square")) {
						SquareGizmo sg = new SquareGizmo(id, x, y);
						model.addGizmo(sg);
					} else if (type.equals("Circle")) {
						CircleGizmo cg = new CircleGizmo(id, x, y);
						model.addGizmo(cg);
					} else if (type.equals("Triangle")) {
						//rotation = Integer.parseInt(read.next());
						TriangleGizmo tg = new TriangleGizmo(id, x, y);
						int rotationCount = countRotations(id, file);
						int i = 0;
						while (i < rotationCount) {
							tg.rotateClockwise();
							i++;
						}
						model.addGizmo(tg);
					} else if (type.equals("Absorber")) {
						x2 = Integer.parseInt(read.next());
						y2 = Integer.parseInt(read.next());
						Absorber abs = new Absorber(x, y, x2, y2);
						model.addAbsorber(abs);
					} else if (type.equals("LeftFlipper")) {
						LeftFlipperGizmo lf = new LeftFlipperGizmo(id, x, y);
						int rotationCount = countRotations(id, file);
						int i = 0;
						while (i < rotationCount) {
							lf.rotateClockwise();
							i++;
						}
						model.addGizmo(lf);
					} else if (type.equals("RightFlipper")) {
						RightFlipperGizmo rf = new RightFlipperGizmo(id, x, y);
						int rotationCount = countRotations(id, file);
						int i = 0;
						while (i < rotationCount) {
							rf.rotateClockwise();
							i++;
						}
						model.addGizmo(rf);
					}
				} 	else if (type.equals("Connect")) {
					id = read.next();
					id2 = read.next();

					int index = model.findGizmoIndex(id);
					for(Gizmo gizmo: model.getGizmos()) {
						if (gizmo.getID().equals(id)){
							gizmo.setConnection(id2);
						}
						System.out.println(gizmo.getID());
					}
					Gizmo g = model.getGizmos().get(index);
					g.setConnection(id2);
				}

				else {

				}
			}

			read.close();
		}catch(IOException e){
			e.printStackTrace();
		}
    }
    
    public int countRotations(String name, File file) {
		int count = 0;
        InputStream is = getClass().getResourceAsStream(file.getName());
		try {
			Scanner read = new Scanner(file);
			String type, id;
			int x, y, x2 = 0, y2 = 0, rotation = 0;
			Float bx, by;
			double xVelo = 0, yVelo = 0, angle;
			int L = 25;

			while (read.hasNextLine()) {
				type = read.next();
				if (type.equals("Rotate")) {
					id = read.next();
					if (id.equals(name)) {
						count++;
					}
				}
			}
			read.close();

		}catch(IOException e){
			e.printStackTrace();
		}
		return count;
    }
}
