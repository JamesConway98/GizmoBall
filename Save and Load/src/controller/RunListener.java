package controller;

import model.Model;
import model.SquareGizmo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunListener implements ActionListener {

	private Timer timer;
	private Model model;

	public RunListener(Model m) {
		model = m;
		timer = new Timer(50, this);
	}

	@Override
	public final void actionPerformed(final ActionEvent e) {

		if (e.getSource() == timer) {
			model.moveBall();
		} else
			switch (e.getActionCommand()) {
				case "Start":
					timer.start();
					break;
				case "Stop":
					timer.stop();
					break;
				case "Tick":
					model.moveBall();
					break;
					case "Save":
						model.saveGame();
						break;
				case "Load":
					model.loadGame();
					break;
				case "Add Square":
					model.addRandomSquare();
					break;
				case "Add Triangle":
					model.addRandomTriangle();
					break;
				case "Add Flipper":
					model.addRandomFlipper();
					break;
				case "Quit":
					System.exit(0);
					break;
		}
	}
}
