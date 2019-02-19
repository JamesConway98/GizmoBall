package controller;

import model.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.locks.ReentrantLock;

public class keypressListener implements KeyListener {

    private Model model;
    private static final int L = 25;
    private static final int INITIAL_VELOCTIY = -50;
    private ReentrantLock lock = new ReentrantLock();

    public keypressListener(Model m) {
        model = m;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            Thread moveFlippers = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    for(int i = 0; i < 36; i++) {
                        try {
                            model.moveFlippers();
                            Thread.sleep(50);
                        } catch(InterruptedException ex) {
                            ex.printStackTrace();
                        }
                   }
                    lock.unlock();
                }
            });
            if(!lock.isLocked()) {
                moveFlippers.start();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
