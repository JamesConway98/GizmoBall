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
        int x = 0, y = 0;
        x = (e.getX() - 50)/ BuildBoard.L;
        y = (e.getY() - 50)/ BuildBoard.L;
        if(x >= 0 && x <= 18 && y >= 0 && y <= 18) {
            initialGridX = (e.getX()- 50)/ BuildBoard.L;
            initialGridY = (e.getY()- 50)/ BuildBoard.L;
        } else {
            initialGridX = -1;
            initialGridY = -1;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(initialGridX != -1 && initialGridY != -1) {
            finalGridX = (e.getX() - 50) / BuildBoard.L;
            finalGridY = (e.getY() - 50) / BuildBoard.L;
            if (finalGridX < 0) {
                finalGridX = 0;
            }
            if (finalGridX > 18) {
                finalGridX = 18;
            }
            if (finalGridY < 0) {
                finalGridY = 0;
            }

            if (finalGridY > 18) {
                finalGridY = 18;
            }
            leftX = Math.min(initialGridX, finalGridX);
            rightX = Math.max(initialGridX, finalGridX);
            topY = Math.min(initialGridY, finalGridY);
            bottomY = Math.max(initialGridY, finalGridY);

            model.addAbsorber(new Absorber(leftX, topY, rightX, bottomY));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
