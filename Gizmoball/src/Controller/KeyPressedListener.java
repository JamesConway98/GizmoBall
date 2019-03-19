package Controller;

import model.Absorber;
import model.Gizmos.Flipper;
import model.Gizmos.Gizmo;
import model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPressedListener implements KeyListener {

    private Model model;

    public KeyPressedListener(Model m) {
        model = m;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //model.keyPressed(e.getKeyChar());
        for(Gizmo gizmo:model.getAllGizmoByKey(e.getKeyChar())){
            if(gizmo instanceof Flipper){
                gizmo.setGizmoActive(true);
            }else {
                gizmo.toggleColour();
            }
        }
        for(Absorber ignored : model.getAllAbsorberByKey(e.getKeyChar())) {
            model.fire();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for(Gizmo gizmo:model.getAllGizmoByKey(e.getKeyChar())){
            if(gizmo instanceof Flipper) {
                ((Flipper) gizmo).flipMoveToggle();
            }
        }
    }
}

