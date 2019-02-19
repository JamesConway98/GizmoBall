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

		model.setBallSpeed(200, 150);

		model.addGizmo(new SquareGizmo(16, 0));
		model.addGizmo(new SquareGizmo(4, 2));
		model.addGizmo(new SquareGizmo(15, 5));
		model.addGizmo(new SquareGizmo(8, 6));
		model.addGizmo(new SquareGizmo(9, 6));
		model.addGizmo(new SquareGizmo(10, 6));

		model.addGizmo(new SquareGizmo(1, 13));
		model.addGizmo(new SquareGizmo(1, 15));
		model.addGizmo(new SquareGizmo(12, 8));
		model.addGizmo(new SquareGizmo(14, 9));

		model.addGizmo(new SquareGizmo(9, 11));
		model.addGizmo(new TriangleGizmo(10, 11));

		model.addGizmo(new SquareGizmo(12, 13));
		model.addGizmo(new TriangleGizmo(12, 14));
		model.addGizmo(new SquareGizmo(14, 7));
		model.addGizmo(new TriangleGizmo(15, 7));

		model.addGizmo(new TriangleGizmo(4, 0));
		model.addGizmo(new TriangleGizmo(0, 0));
		model.addGizmo(new TriangleGizmo(0, 2));
		model.addGizmo(new TriangleGizmo(15, 18));
		model.addGizmo(new TriangleGizmo(16, 17));
		model.addGizmo(new TriangleGizmo(17, 16));
		model.addGizmo(new TriangleGizmo(4, 0));
		model.addGizmo(new TriangleGizmo(6, 10));
		model.addGizmo(new TriangleGizmo(17, 2));


		model.addGizmo(new CircleGizmo(15, 16));
		model.addGizmo(new CircleGizmo(3, 16));
		model.addGizmo(new CircleGizmo(6, 14));
		model.addGizmo(new CircleGizmo(5, 19));

		model.addGizmo(new CircleGizmo(9, 2));
		model.addGizmo(new CircleGizmo(7, 2));
		model.addGizmo(new CircleGizmo(8, 4));
		model.addGizmo(new CircleGizmo(2, 10));
		model.addGizmo(new CircleGizmo(3, 7));
		model.addGizmo(new CircleGizmo(1, 8));

        RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
