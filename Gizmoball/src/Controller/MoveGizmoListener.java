package Controller;

import model.Gizmos.Gizmo;
import model.Model;
import view.BuildBoard;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class MoveGizmoListener implements MouseListener, Observer {

    private Model model;
    private Gizmo movingGizmo;
    private boolean dropped = false;

    public MoveGizmoListener(Model m){
        model = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = 0, y = 0;
        x = (e.getX() - 50) / BuildBoard.L;
        y = (e.getY() - 50) / BuildBoard.L;

        if(!dropped && model.getGizmoByGrid(x, y)!=null) {
            movingGizmo = model.getGizmoByGrid(x, y);
            model.moveGizmo(movingGizmo, x, y);
            //This flips between true and false
            dropped^= true;
        }else if(movingGizmo!=null){
            model.moveGizmo(movingGizmo, 100, 100); //need this to clear grid space without clearing this gizmo
            model.clearGridSpace(x, y);
            model.moveGizmo(movingGizmo, x, y);
            movingGizmo = null;
            //This flips between true and false
            dropped^= true;
        }

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
        model.moveGizmo(movingGizmo, x, y);
    }
}
