package Controller;

import model.Gizmos.LeftFlipperGizmo;
import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddLeftFlipperListener implements MouseListener {

    private Model model;

    public AddLeftFlipperListener(Model m) {
        model = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 0, y = 0;
        x = (e.getX() - 50)/ BuildBoard.L;
        y = (e.getY() - 50)/ BuildBoard.L;
        if(x >= 0 && x <= 18 && y >= 0 && y <= 18) {
            //TODO unique ids
            model.addGizmo(new LeftFlipperGizmo("LF1", x, y));
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
