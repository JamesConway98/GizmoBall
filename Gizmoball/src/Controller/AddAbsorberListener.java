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

        if(!dropped) {
            initialGridX = ((e.getX() - 50) / BuildBoard.L);
            initialGridY = (e.getY() - 50) / BuildBoard.L;

            //TODO unique ids
            Absorber absorber = new Absorber("A0", initialGridX, initialGridY, initialGridX, initialGridY);
            model.addPreviewAbsorber(absorber);
        }
        model.finishPreviewAbsorber();
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
            }if (x > 19) {
                x = 19;
            }if (y < 0) {
                y = 0;
            }if (y > 19) {
                y = 19;
            }

            model.editPreviewAbsorber(x, y);
        }
    }
}
