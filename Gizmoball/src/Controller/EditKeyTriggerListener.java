package Controller;

import model.Absorber;
import model.Gizmos.Gizmo;
import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditKeyTriggerListener implements MouseListener {

    private Model model;

    public EditKeyTriggerListener(Model m) {
        model = m;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 0, y =0;
        x = (e.getX() - 50)/ BuildBoard.L;
        y = (e.getY() - 50)/ BuildBoard.L;
        for(Gizmo gizmo:model.getGizmos()){
            if(gizmo.getGridX()== x && gizmo.getGridY()== y){
                model.setSelectedGizmo(gizmo);
            }
        }
        for(Absorber absorber : model.getAbsorbers()) {
            if(x >= absorber.getGridX1() && x <= absorber.getGridX2() && y >= absorber.getGridY1() && y <= absorber.getGridY2()) {
                model.setSelectedAbsorber(absorber);
            }
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
