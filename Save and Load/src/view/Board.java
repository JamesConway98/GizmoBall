package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.Ball;
import model.CircularGizmo;
import model.Model;
import model.SquareGizmo;
import model.TriangleGizmo;
import model.VerticalLine;
import physics.Vect;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public  class Board extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	protected int width;
	protected int height;
	protected Model gm;

	public Board(int w, int h, Model m) {
		// Observe changes in Model
		m.addObserver(this);
		width = w;
		height = h;
		gm = m;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	// Fix onscreen size
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		// Draw all the vertical lines
		for (VerticalLine vl : gm.getLines()) {
			g2.fillRect(vl.getX(), vl.getY(), vl.getWidth(), 1);
		}

		// Draw all square gizmos
		for (SquareGizmo s : gm.getSquares()) {
			g2.setColor(s.getColour());
			g2.fillRect(s.getX(), s.getY(), s.getLength(), s.getLength());
		}

		// Draw all circular gizmos
		for (CircularGizmo c : gm.getCirculars()) {
			g2.setColor(c.getColour());
			g2.fillOval(c.getX(), c.getY(), c.getLength(), c.getLength());
		}

		for (TriangleGizmo t : gm.getTriangles()) {
			g2.setColor(t.getColour());

			//g2.drawPolygon(x, y, 3);
			g2.fill(t.getOutline());
		}


		Ball b = gm.getBall();
		if (b != null) {
			g2.setColor(b.getColour());
			int x = (int) (b.getExactX() - b.getRadius());
			int y = (int) (b.getExactY() - b.getRadius());
			int width = (int) (2 * b.getRadius());
			g2.fillOval(x, y, width, width);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		repaint();
	}

}
