package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

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

		//Draw All Gizmos
		for (Gizmo b : gm.getGizmos()) {
			g2.setColor(b.getColour());
			if (b instanceof SquareGizmo){
				g2.fillRect(b.getX(), b.getY(), b.getLength(), b.getLength());
			} else if (b instanceof TriangleGizmo){
				int triangleRotation = b.getRotation();
				if (triangleRotation == 0){
					int x[] = {b.getX(), b.getX(), b.getX() + b.getLength()};
					int y[] = {b.getY() + b.getLength(), b.getY(), b.getY()};
					g2.fillPolygon(x, y, 3);
				} else if (triangleRotation == 1){
					int x[] = {b.getX(), b.getX() + b.getLength(), b.getX() + b.getLength()};
					int y[] = {b.getY(), b.getY(), b.getY() + b.getLength()};
					g2.fillPolygon(x, y, 3);
				} else if (triangleRotation == 2){
					int x[] = {b.getX() + b.getLength(), b.getX() + b.getLength(), b.getX()};
					int y[] = {b.getY() + b.getLength(), b.getY(), b.getY() + b.getLength()};
					g2.fillPolygon(x, y, 3);
				} else if (triangleRotation == 3){
					int x[] = {b.getX() + b.getLength(), b.getX(), b.getX()};
					int y[] = {b.getY() + b.getLength(), b.getY() + b.getLength(), b.getY()};
					g2.fillPolygon(x, y, 3);
				}
			} else if (b instanceof CircleGizmo){
				g2.fillOval(b.getX(), b.getY(), b.getLength(), b.getLength());
			} else if (b instanceof LeftFlipperGizmo){
				g2.fillRoundRect(b.getX(), b.getY(), b.getLength()/2, b.getLength()*2, b.getLength()/2, b.getLength()/2);
			}
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
