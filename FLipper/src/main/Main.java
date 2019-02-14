package main;

import model.*;
import view.RunGui;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Main {

	public static void main(String[] args) {
		try {
			// Use the platform look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Look and Feel error in Main");
		}

		Model model = new Model();

		model.setBallSpeed(200, 195);

		model.addGizmo(new SquareGizmo(350, 350));
		//model.addGizmo(new SquareGizmo(50, 150));

		model.addGizmo(new SquareGizmo(250, 0));
		model.addGizmo(new SquareGizmo(250, 50));
		model.addGizmo(new SquareGizmo(250, 100));
		model.addGizmo(new SquareGizmo(250, 150));
		model.addGizmo(new SquareGizmo(250, 200));
		model.addGizmo(new SquareGizmo(250, 250));
		model.addGizmo(new SquareGizmo(200, 250));
		model.addGizmo(new SquareGizmo(150, 250));
		model.addGizmo(new SquareGizmo(100, 250));
		model.addGizmo(new SquareGizmo(50, 250));
		model.addGizmo(new SquareGizmo(0, 250));

//		model.addGizmo(new CircleGizmo(100, 0));
//		model.addGizmo(new CircleGizmo(150, 200));
//
//		model.addGizmo(new TriangleGizmo(450,0));
//		model.addGizmo(new TriangleGizmo(0,100));
//		model.addGizmo(new TriangleGizmo(450,450));

//		Gizmo t1 = new TriangleGizmo(100,90);
//		((TriangleGizmo) t1).rotateClockwise();
//		((TriangleGizmo) t1).rotateClockwise();
//		model.addGizmo(t1);

		model.addGizmo(new LeftFlipperGizmo(300, 300, 57));
		//model.addGizmo(new LeftFlipperGizmo(50, 50, 15));
        model.addGizmo(new LeftFlipperGizmo(150, 150, 0));
        model.addGizmo(new LeftFlipperGizmo(200, 200, 90));
        model.addGizmo(new LeftFlipperGizmo(50, 0, -21));
        model.addGizmo(new LeftFlipperGizmo(0, 200, 140));
        model.addGizmo(new LeftFlipperGizmo(200, 0, 24));
        RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
