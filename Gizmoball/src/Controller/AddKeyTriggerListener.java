package Controller;

import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddKeyTriggerListener implements MouseListener {

    private Model model;

    public AddKeyTriggerListener(Model m) {
        model = m;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 0, y =0;
        x = (e.getX() - 50)/ BuildBoard.L;
        y = (e.getY() - 50)/ BuildBoard.L;
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
