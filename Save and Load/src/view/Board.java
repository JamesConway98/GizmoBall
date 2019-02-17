package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
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
					g2.drawPolygon(x, y, 3);
					g2.fillPolygon(x, y, 3);
				}
			} else if (b instanceof CircleGizmo){
				g2.fillOval(b.getX(), b.getY(), b.getLength(), b.getLength());
			} else if (b instanceof Absorber){
				g2.fillRect(b.getX(), b.getY(), b.getLength(), ((Absorber) b).getHeight());
			} else if (b instanceof LeftFlipperGizmo){


				Graphics2D g2d = (Graphics2D) g.create();
				g2.setColor(g.getColor());
//				g2d.rotate(Math.toRadians(270), x + b.getLength()/2, y + b.getLength()/2);
//				g2d.fill(shape);
				RoundRectangle2D lFlip = new RoundRectangle2D.Double(b.getX(), b.getY(), b.getLength()/2, b.getLength()*2, b.getLength()/2, b.getLength()/2);
				g2d.rotate(Math.toRadians(((LeftFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 0.25, b.getY() + b.getLength() * 0.25);
				g2d.draw(lFlip);
				g2d.fill(lFlip);
				//g2.fillRoundRect(b.getX(), b.getY(), b.getLength()/2, b.getLength()*2, b.getLength()/2, b.getLength()/2);
				//transform.
				g2d.dispose();
				Graphics2D g2e = (Graphics2D) g.create();
				g2e.setColor(Color.RED);
				g2e.drawRect(((int) ((LeftFlipperGizmo) b).v1.x()), ((int) ((LeftFlipperGizmo) b).v1.y()), 100, 100);
				g2e.drawRect(((int) ((LeftFlipperGizmo) b).v2.x()), ((int) ((LeftFlipperGizmo) b).v2.y()), 100, 100);
				g2e.drawRect(((int) ((LeftFlipperGizmo) b).v3.x()), ((int) ((LeftFlipperGizmo) b).v3.y()), 100, 100);
				g2e.drawRect(((int) ((LeftFlipperGizmo) b).v4.x()), ((int) ((LeftFlipperGizmo) b).v4.y()), 100, 100);
				g2e.drawRect(((int) ((LeftFlipperGizmo) b).v5.x()), ((int) ((LeftFlipperGizmo) b).v5.y()), 100, 100);
				g2e.drawRect(((int) ((LeftFlipperGizmo) b).v6.x()), ((int) ((LeftFlipperGizmo) b).v6.y()), 100, 100);

				g2e.dispose();
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
