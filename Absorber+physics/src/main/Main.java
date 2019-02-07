package main;

import model.*;
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

		model.getBall().stop();
		model.setBallSpeed(0, -50*25);
		model.getBall().setExactX(480);
		model.getBall().setExactY(480);

		//model.addAbsorber(new Absorber(0, 490, 500, 500));

		RunGui gui = new RunGui(model);
		gui.createAndShowGUI();
	}
}
