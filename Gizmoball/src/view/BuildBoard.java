package view;

import Controller.AddSquareListener;
import model.CircleGizmo;
import model.Gizmo;
import model.Model;
import model.SquareGizmo;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class BuildBoard extends JPanel implements Observer {

    protected int width;
    protected int height;
    public static final int L = 40;
    protected Model model;

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
        for(int i = 0; i<21; i++) {
            g.drawLine(i*L+50, 50, i*L+50, 815);
        }
        //Draw horizontal lines
        for(int i = 0; i<21; i++) {
            g.drawLine(50, i*L+50, 850, i*L+50);
        }

        for (Gizmo b : model.getGizmos()) {
            g2.setColor(b.getColour());
            if (b instanceof SquareGizmo) {
                g2.fillRect(b.getX()*L+50, b.getY()*L+50, L, L);
            }else if (b instanceof CircleGizmo){
                g2.fillOval(b.getX()*L+50, b.getY()*L+50, L, L);
            }
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }
}

