package view;

import controller.RunListener;
import model.Model;
import view.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class RunGui {

	private Model model;
	private JFrame frame;
	private ActionListener listener;
	private KeyListener keyListener;
	private Board board;

	public RunGui(Model m) {
		model = m;

		// RunListener catches all GUI events. In reality might have many listeners.
		listener = new RunListener(m);
	}

	public void createAndShowGUI() {

		frame = new JFrame("Thur 4 - Save Load");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);
		frame.addKeyListener(keyListener);

		// Board is passed the Model.Model so it can act as Observer
		board = new Board(500, 500, model);
		Container cp = frame.getContentPane();

		Font gf = new Font("Arial", Font.BOLD, 12);

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4, 1));

		JButton button1 = new JButton("Start");
		button1.setFocusable(false);
		button1.setFont(gf);
		button1.addActionListener(listener);
		button1.setMaximumSize(new Dimension(100, 100));
		buttons.add(button1);

		JButton button2 = new JButton("Stop");
		button2.setFocusable(false);
		button2.setFont(gf);
		button2.addActionListener(listener);
		button2.setMaximumSize(new Dimension(100, 100));
		buttons.add(button2);

		JButton button3 = new JButton("Load");
		button3.setFocusable(false);
		button3.setFont(gf);
		button3.addActionListener(listener);
		button3.setMaximumSize(new Dimension(100, 100));
		buttons.add(button3);

		JButton button4 = new JButton("Save");
		button4.setFocusable(false);
		button4.setFont(gf);
		button4.addActionListener(listener);
		button4.setMaximumSize(new Dimension(100, 100));
		buttons.add(button4);

		JButton button5 = new JButton("Tick");
		button5.setFocusable(false);
		button5.setFont(gf);
		button5.addActionListener(listener);
		button5.setMaximumSize(new Dimension(100, 100));
		buttons.add(button5);

		JButton button6 = new JButton("Add Square");
		button6.setFocusable(false);
		button6.setFont(gf);
		button6.addActionListener(listener);
		button6.setMaximumSize(new Dimension(100, 100));
		buttons.add(button6);

		JButton button7 = new JButton("Add Triangle");
		button7.setFocusable(false);
		button7.setFont(gf);
		button7.addActionListener(listener);
		button7.setMaximumSize(new Dimension(100, 100));
		buttons.add(button7);

		JButton button8 = new JButton("Add Flipper");
		button8.setFocusable(false);
		button8.setFont(gf);
		button8.addActionListener(listener);
		button8.setMaximumSize(new Dimension(100, 100));
		buttons.add(button8);

		cp.add(buttons, BorderLayout.LINE_START);
		cp.add(board, BorderLayout.CENTER);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
