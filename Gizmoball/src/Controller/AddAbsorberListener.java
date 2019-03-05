package Controller;

import model.Absorber;
import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddAbsorberListener implements MouseListener {

    private int initialGridX, initialGridY, finalGridX, finalGridY;
    private Model model;

    public AddAbsorberListener(Model m) {
        model = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        initialGridX = (e.getX()- 50)/ BuildBoard.L;
        initialGridY = (e.getY()- 50)/ BuildBoard.L;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        finalGridX = (e.getX()- 50)/ BuildBoard.L;
        finalGridY = (e.getY()- 50)/ BuildBoard.L;
        model.addAbsorber(new Absorber(initialGridX, initialGridY, finalGridX, finalGridY));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
