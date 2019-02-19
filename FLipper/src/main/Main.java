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

		model.addGizmo(new SquareGizmo(350, 350));
		model.addGizmo(new TriangleGizmo(50, 150));
		model.addGizmo(new CircleGizmo(400, 100));

      	model.addGizmo(new LeftFlipperGizmo(150, 150, 0));
		model.addGizmo(new RightFlipperGizmo(200, 150, 0));

        RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
