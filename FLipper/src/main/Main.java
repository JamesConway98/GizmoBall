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

      	Gizmo lf0 = new LeftFlipperGizmo(50, 50, 0);
		Gizmo lf1 = new LeftFlipperGizmo(150, 200, 0);
		lf1.rotateClockwise();
		Gizmo lf2 = new LeftFlipperGizmo(50, 250, 0);
		lf2.rotateClockwise();
		lf2.rotateClockwise();
		Gizmo lf3 = new LeftFlipperGizmo(150, 300, 0);
		lf3.rotateClockwise();
		lf3.rotateClockwise();
		lf3.rotateClockwise();
		System.out.println(lf0.getRotation());
		System.out.println(lf1.getRotation());
		System.out.println(lf2.getRotation());
		System.out.println(lf3.getRotation());
		model.addGizmo(lf0);
		model.addGizmo(lf1);
		model.addGizmo(lf2);
		model.addGizmo(lf3);


		Gizmo rf0 = new RightFlipperGizmo(300, 150, 0);
		Gizmo rf1 = new RightFlipperGizmo(300, 200, 0);
		rf1.rotateClockwise();
		Gizmo rf2 = new RightFlipperGizmo(300, 250, 0);
		rf2.rotateClockwise();
		rf2.rotateClockwise();
		Gizmo rf3 = new RightFlipperGizmo(300, 300, 0);
		rf3.rotateClockwise();
		rf3.rotateClockwise();
		rf3.rotateClockwise();
		System.out.println(rf0.getRotation());
		System.out.println(rf1.getRotation());
		System.out.println(rf2.getRotation());
		System.out.println(rf3.getRotation());
		model.addGizmo(rf0);
		model.addGizmo(rf1);
		model.addGizmo(rf2);
		model.addGizmo(rf3);

        RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
