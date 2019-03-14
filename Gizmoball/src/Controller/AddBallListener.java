package Controller;

import model.Absorber;
import model.Ball;
import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddBallListener implements MouseListener {

    private Model model;

    public AddBallListener(Model m) {
        model = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 0, y = 0;
        x = (e.getX() - 50)/ BuildBoard.L;
        y = (e.getY() - 50)/ BuildBoard.L;
        if(x >= 0 && x <= 18 && y >= 0 && y <= 18) {
            model.addBall(new Ball(x, y, -50, -50));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
