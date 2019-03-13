package Controller;

import model.Absorber;
import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddAbsorberListener implements MouseListener {

    private int initialGridX, initialGridY, finalGridX, finalGridY, leftX, rightX, topY, bottomY;
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
        leftX = Math.min(initialGridX, finalGridX);
        rightX = Math.max(initialGridX, finalGridX);
        topY = Math.min(initialGridY, finalGridY);
        bottomY = Math.max(initialGridY, finalGridY);

        model.addAbsorber(new Absorber(leftX, topY, rightX, bottomY));
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
