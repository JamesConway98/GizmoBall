package Controller;

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
        model.keyPressed(e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

