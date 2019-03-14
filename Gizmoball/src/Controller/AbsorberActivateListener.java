package Controller;

import model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AbsorberActivateListener implements KeyListener {

    private Model model;
    private static final int INITIAL_VELOCTIY = -50;
    private final int L;

    public AbsorberActivateListener(Model m) {
        model = m;
        L = Model.L;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            if(model.getBall().stopped()) {
                model.getBall().setExactY(model.getBall().getExactY() - (model.getBall().getRadius() * 2));
                model.setBallSpeed(0, L * INITIAL_VELOCTIY);
                model.getBall().start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
