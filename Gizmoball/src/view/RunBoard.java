package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Observable;
import java.util.Observer;

public class RunBoard extends JPanel implements Observer {

    protected int width;
    protected int height;
    public static final int L = 40;
    protected Model model;
    private MouseListener activeMouseListener;

    public RunBoard(int w, int h, Model m) {
        width = w;
        height = h;
        model = m;
        m.addObserver(this);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    // Fix onscreen size
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        for (Gizmo b : model.getGizmos()) {
            g2.setColor(b.getColour());
            int xPos = b.getX(), yPos = b.getY();
            if (b instanceof SquareGizmo) {
                g2.fillRect(xPos, yPos, L, L);
            } else if (b instanceof CircleGizmo) {
                g2.fillOval(xPos, yPos, L, L);
            } else if (b instanceof TriangleGizmo) {
                int triangleRotation = b.getRotation();

                //rotation 0
                int x[] = {xPos, xPos, xPos + L};
                int y[] = {yPos + L, yPos, yPos};
                //Change points depending on rotation
                if (triangleRotation == 1) {
                    x[1] = xPos + L;
                    y[0] = yPos;
                    y[2] = yPos + L;
                } else if (triangleRotation == 2) {
                    x[0] = xPos + L;
                    x[1] = xPos + L;
                    x[2] = xPos;
                    y[2] = yPos + L;
                } else if (triangleRotation == 3) {
                    x[0] = xPos + L;
                    x[2] = xPos;
                    y[1] = yPos + L;
                }
                g2.fillPolygon(x, y, 3);

                //The 2 Flippers have been changed to draw in grid cells, so they might not act correctly for collisions
            } else if (b instanceof LeftFlipperGizmo){
                Graphics2D g2d = (Graphics2D) g.create();
                g2.setColor(g.getColor());
                int lfr = b.getRotation();
                RoundRectangle2D lFlip = new RoundRectangle2D.Double(b.getX(), b.getY(), b.getLength()/2, b.getLength()/2, b.getLength()/2, b.getLength()/2);
                if (lfr == 0) {
                    lFlip = new RoundRectangle2D.Double(b.getX(), b.getY(), b.getLength()/2, b.getLength()*2, b.getLength()/2, b.getLength()/2);
                    g2d.rotate(Math.toRadians(((LeftFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 0.25, b.getY() + b.getLength() * 0.25);
                } else if(lfr == 1) {
                    lFlip = new RoundRectangle2D.Double(b.getX(), b.getY(), b.getLength()*2, b.getLength()/2, b.getLength()/2, b.getLength()/2);
                    g2d.rotate(Math.toRadians(((LeftFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 1.75, b.getY() + b.getLength() * 0.25);
                } else if(lfr == 2) {
                    lFlip = new RoundRectangle2D.Double(b.getX() + (1.5 * b.getLength()), b.getY() , b.getLength()/2, b.getLength()*2, b.getLength()/2, b.getLength()/2);
                    g2d.rotate(Math.toRadians(((LeftFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 1.75, b.getY() + b.getLength() * 1.75);
                } else if(lfr == 3) {
                    lFlip = new RoundRectangle2D.Double(b.getX(), b.getY() + (1.5 * b.getLength()), b.getLength()*2, b.getLength()/2, b.getLength()/2, b.getLength()/2);
                    g2d.rotate(Math.toRadians(((LeftFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 0.25, b.getY() + b.getLength() * 1.75);
                }
                g2d.draw(lFlip);
                g2d.fill(lFlip);
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

            } else if (b instanceof RightFlipperGizmo){
                Graphics2D g2d = (Graphics2D) g.create();
                g2.setColor(g.getColor());
                int rfr = b.getRotation();
                RoundRectangle2D lFlip = new RoundRectangle2D.Double(b.getX() + 1.5 * b.getLength(), b.getY(), b.getLength()/2, b.getLength()*2, b.getLength()/2, b.getLength()/2);
                if (rfr == 2) {
                    lFlip = new RoundRectangle2D.Double(b.getX(), b.getY(), b.getLength()/2, b.getLength()*2, b.getLength()/2, b.getLength()/2);
                    g2d.rotate(Math.toRadians(((RightFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 0.25, b.getY() + b.getLength() * 1.75);
                } else if(rfr == 3) {
                    lFlip = new RoundRectangle2D.Double(b.getX(), b.getY(), b.getLength()*2, b.getLength()/2, b.getLength()/2, b.getLength()/2);
                    g2d.rotate(Math.toRadians(((RightFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 0.25, b.getY() + b.getLength() * 0.25);
                } else if(rfr == 0) {
                    lFlip = new RoundRectangle2D.Double(b.getX() + (1.5 * b.getLength()), b.getY() , b.getLength()/2, b.getLength()*2, b.getLength()/2, b.getLength()/2);
                    g2d.rotate(Math.toRadians(((RightFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 1.75, b.getY() + b.getLength() * 0.25);
                } else if(rfr == 1) {
                    lFlip = new RoundRectangle2D.Double(b.getX(), b.getY() + (1.5 * b.getLength()), b.getLength()*2, b.getLength()/2, b.getLength()/2, b.getLength()/2);
                    g2d.rotate(Math.toRadians(((RightFlipperGizmo) b).getAngle()), b.getX() + b.getLength() * 1.75, b.getY() + b.getLength() * 1.75);
                }
                g2d.draw(lFlip);
                g2d.fill(lFlip);
                g2d.dispose();
            }
        }

        for(Absorber abs: model.getAbsorbers()){
            g2.setColor(abs.getColour());
            g2.fillRect(abs.getXpos1(), abs.getYpos1(),abs.getWidth()*L+L,   abs.getHeight()*L+L);
        }

    }

    public void setActiveMouseListener(MouseListener ml){
        this.removeMouseListener(activeMouseListener);
        this.activeMouseListener = ml;
        this.addMouseListener(ml);
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
        setActiveMouseListener(model.getActiveMouseListener());
    }
}
