package Controller;

import model.Absorber;
import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class AddAbsorberListener implements MouseListener, Observer {

    private int initialGridX, initialGridY, finalGridX, finalGridY, leftX, rightX, topY, bottomY;
    private Model model;
    private boolean dropped = true;

    public AddAbsorberListener(Model m) {
        model = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        //This flips between true and false
        dropped^= true;

        int x = 0, y = 0;
        x = (e.getX() - 50) / BuildBoard.L;
        y = (e.getY() - 50) / BuildBoard.L;

        if(!dropped) {
           // if (x >= 0 && x <= 18 && y >= 0 && y <= 18) {
                initialGridX = (e.getX() - 50) / BuildBoard.L;
                initialGridY = (e.getY() - 50) / BuildBoard.L;
            /*} else {
                initialGridX = -1;
                initialGridY = -1;
            }*/

            Absorber absorber = new Absorber(initialGridX, initialGridY, initialGridX, initialGridY);
            model.addPreviewAbsorber(absorber);
        }
        model.finishPreviewAbsorber();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /*if(initialGridX != -1 && initialGridY != -1) {
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
        }*/
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void update(Observable o, Object arg) {

        int x = 0, y= 0;
        if(arg instanceof MouseEvent){
            x = ((MouseEvent) arg).getX();
            y = ((MouseEvent) arg).getY();
        }
        x = (x - 50)/ BuildBoard.L;
        y = (y - 50)/ BuildBoard.L;
        if(!dropped) {
            if (x < 0) {
                x = 0;
            }if (x > 18) {
                x = 18;
            }if (y < 0) {
                y = 0;
            }if (y> 18) {
                y = 18;
            }
            model.editPreviewAbsorber(x, y);
        }
    }
}
