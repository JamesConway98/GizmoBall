package Controller;

import model.Model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Observable;

public class MoveMouseListener extends Observable implements MouseMotionListener {

    Model model;

    public MoveMouseListener(Model m){
        model = m;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        setChanged();
        notifyObservers(e);
    }
}
