package Controller;

import model.Gizmos.*;
import model.Model;
import model.Gizmos.TriangleGizmo;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RotateGizmoListener implements MouseListener {

    private Model model;
    private boolean clockwise;

    public RotateGizmoListener(Model m, boolean clockwise){
        model = m;
        this.clockwise = clockwise;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 0, y =0;
        x = (e.getX() - 50)/ BuildBoard.L;
        y = (e.getY() - 50)/ BuildBoard.L;

        for(Gizmo gizmo:model.getGizmos()){
            if(gizmo.getGridX()== x && gizmo.getGridY()== y){
                if(clockwise) {
                    model.rotateGizmo(gizmo);
                }else{
                    for(int i=0; i<3; i++) {
                        model.rotateGizmo(gizmo);
                    }
                }

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
