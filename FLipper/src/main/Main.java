package main;

import model.*;
import model.Gizmos.*;
import view.RunGui;

import javax.swing.*;

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

		Gizmo t1 = new TriangleGizmo("T1", 475, 0);
		t1.rotateClockwise();
		model.addGizmo(t1);

      	Gizmo lf0 = new LeftFlipperGizmo("LF1",50, 50);
		Gizmo lf1 = new LeftFlipperGizmo("LF2",150, 200);
		lf1.rotateClockwise();
		Gizmo lf2 = new LeftFlipperGizmo("LF3",50, 250);
		lf2.rotateClockwise();
		lf2.rotateClockwise();
		Gizmo lf3 = new LeftFlipperGizmo("LF4",150, 300);
		lf3.rotateClockwise();
		lf3.rotateClockwise();
		lf3.rotateClockwise();
		model.addGizmo(lf0);
		model.addGizmo(lf1);
		model.addGizmo(lf2);
		model.addGizmo(lf3);

		model.addAbsorber(new Absorber(0, 480, 500, 500));

		Gizmo rf0 = new RightFlipperGizmo("RF1",250, 150);
		Gizmo rf1 = new RightFlipperGizmo("RF2",300, 200);
		rf1.rotateClockwise();
		Gizmo rf2 = new RightFlipperGizmo("RF3",300, 250);
		rf2.rotateClockwise();
		rf2.rotateClockwise();
		Gizmo rf3 = new RightFlipperGizmo("RF4",300, 300);
		rf3.rotateClockwise();
		rf3.rotateClockwise();
		rf3.rotateClockwise();
		model.addGizmo(rf0);
		model.addGizmo(rf1);
		model.addGizmo(rf2);
		model.addGizmo(rf3);

        RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
