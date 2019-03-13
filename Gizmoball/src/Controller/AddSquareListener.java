package Controller;

import model.Model;
import model.Gizmos.SquareGizmo;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddSquareListener implements MouseListener {

    private Model model;

    public AddSquareListener(Model m) {
        model = m;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 0, y =0;
        x = (e.getX() - 50)/ BuildBoard.L;
        y = (e.getY() - 50)/ BuildBoard.L;
        //TODO unique ids
        model.addGizmo(new SquareGizmo("S1", x, y));
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
