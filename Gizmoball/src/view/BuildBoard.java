package view;

import Controller.AddSquareListener;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.util.Observable;
import java.util.Observer;

public class BuildBoard extends JPanel implements Observer {

    protected int width;
    protected int height;
    public static final int L = 40;
    protected Model model;
    private MouseListener activeMouseListener;

    public BuildBoard(int w, int h, Model m) {
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

        //Draw vertical lines
        for (int i = 0; i < 21; i++) {
            g.drawLine(i * L + 50, 50, i * L + 50, 815);
        }
        //Draw horizontal lines
        for (int i = 0; i < 21; i++) {
            g.drawLine(50, i * L + 50, 850, i * L + 50);
        }

        for (Gizmo b : model.getGizmos()) {
            g2.setColor(b.getColour());
            int xPos = b.getX() * L + 50, yPos = b.getY() * L + 50;
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
            } else if (b instanceof LeftFlipperGizmo) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2.setColor(g.getColor());
                RoundRectangle2D lFlip = new RoundRectangle2D.Double(xPos,yPos, L / 4, L, L / 4, L / 4);
                g2d.rotate(Math.toRadians(((LeftFlipperGizmo) b).getAngle()), xPos + L * 0.25, yPos + L * 0.25);
                g2d.draw(lFlip);
                g2d.fill(lFlip);
                g2d.dispose();

            } else if (b instanceof RightFlipperGizmo) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2.setColor(g.getColor());
                int width = 10;
                RoundRectangle2D lFlip = new RoundRectangle2D.Double(xPos + L - width , yPos, L / 4, L, L / 4, L / 4);
                g2d.rotate(Math.toRadians(((RightFlipperGizmo) b).getAngle()), xPos + L * 1.25, yPos + L * 0.25);
                g2d.draw(lFlip);
                g2d.fill(lFlip);
                g2d.dispose();
            }
        }

        for(Absorber abs: model.getAbsorbers()){
            g2.setColor(abs.getColour());
            g2.fillRect(abs.getXpos1()*L+50, abs.getYpos1()*L+50,
                    abs.getWidth()*L+L,   abs.getHeight()*L+L);
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

