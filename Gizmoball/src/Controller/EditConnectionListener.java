package Controller;

import model.Gizmos.Flipper;
import model.Gizmos.Gizmo;
import model.Gizmos.LeftFlipperGizmo;
import model.Gizmos.RightFlipperGizmo;
import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EditConnectionListener implements MouseListener {

    private Model model;

    public EditConnectionListener(Model m) {
        model = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = 0, y = 0;
        x = (e.getX() - 50)/ BuildBoard.L;
        y = (e.getY() - 50)/ BuildBoard.L;

        Gizmo gizmo = model.getGizmoByGrid(x, y);

        if(model.getSelectedGizmo()!= null) {
            if (x >= 0 && x <= 19 && y >= 0 && y <= 19) {
                if(gizmo instanceof Flipper) {
                    model.addConnection(gizmo);
                }else{
                    model.setSelectedGizmo(gizmo);
                }
            }
        }else if(!(gizmo instanceof Flipper)){
            model.setSelectedGizmo(gizmo);
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
