package controller;

import model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keypressListener implements KeyListener {

    private Model model;

    public keypressListener(Model m) {
        model = m;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            model.getBall().start();
            model.getBall().setExactX(500-model.getBall().getRadius());
            model.getBall().setExactY(480-model.getBall().getRadius());
            model.setBallSpeed(0, -25*50);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
