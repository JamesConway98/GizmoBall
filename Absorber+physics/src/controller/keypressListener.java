package controller;

import model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keypressListener implements KeyListener {

    private Model model;
    private static final int L = 25;
    private static final int INITIAL_VELOCTIY = -50;

    public keypressListener(Model m) {
        model = m;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            if(model.getBall().stopped()) {
                model.getBall().setExactY(480 - model.getBall().getRadius());
                model.getBall().setExactX(500 - model.getBall().getRadius());
                model.setBallSpeed(0, L * INITIAL_VELOCTIY);
                model.getBall().start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
