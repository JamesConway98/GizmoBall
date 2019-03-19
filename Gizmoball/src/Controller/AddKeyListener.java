package Controller;

import model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AddKeyListener implements KeyListener {

    private Model model;

    public AddKeyListener(Model m) {
        model = m;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        if(model.getActiveMouseListener() != null) {
            if(model.getActiveMouseListener()instanceof EditKeyTriggerListener) {
                model.setKeyToSelectedObject(e.getKeyChar());
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
