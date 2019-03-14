//package controller;
//
//import model.Model;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class AbsorberActivateListener implements KeyListener {
//
//    private Model model;
//    private static final int L = 25;
//    private static final int INITIAL_VELOCTIY = -50;
//    private ReentrantLock lock = new ReentrantLock();
//
//    public AbsorberActivateListener(Model m) {
//        model = m;
//    }
//
//    @Override
//    public void keyTyped(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
//            System.out.println("KeyPressed");
//            if(model.getBall().stopped()) {
//                model.getBall().setExactY(480 - model.getBall().getRadius());
//                model.getBall().setExactX(500 - model.getBall().getRadius());
//                model.setBallSpeed(0, L * INITIAL_VELOCTIY);
//                model.getBall().start();
//            }
//        }
//
//        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
//            Thread moveFlippers = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    lock.lock();
//                    for(int i = 0; i < 1; i++) {
//                        try {
//                            model.getGizmos().get(model.findGizmoIndex("LF1")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF2")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF3")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF4")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF5")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF6")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF7")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF8")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF9")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF10")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF11")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("LF12")).setGizmoActive(true);
//
//                            model.getGizmos().get(model.findGizmoIndex("RF1")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("RF2")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("RF3")).setGizmoActive(true);
//                            model.getGizmos().get(model.findGizmoIndex("RF4")).setGizmoActive(true);
//                            Thread.sleep(50);
//                        } catch(InterruptedException ex) {
//                            ex.printStackTrace();
//                        }
//                   }
//                    lock.unlock();
//                }
//            });
//            if(!lock.isLocked()) {
//                moveFlippers.start();
//            }
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//}

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
        if(e.getKeyChar() == 's' || e.getKeyChar() == 'S') {
            if(model.getBall().stopped()) {
                model.getBall().setExactY(480 - model.getBall().getRadius());
                model.getBall().setExactX(500 - model.getBall().getRadius());
                model.setBallSpeed(0, L * INITIAL_VELOCTIY);
                model.getBall().start();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            Thread moveFlippers = new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    for(int i = 0; i < 1; i++) {
                        try {
                            model.getGizmos().get(model.findGizmoIndex("LF1")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF2")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF3")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF4")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF5")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF6")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF7")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF8")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF9")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF10")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF11")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("LF12")).setGizmoActive(true);

                            model.getGizmos().get(model.findGizmoIndex("RF1")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("RF2")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("RF3")).setGizmoActive(true);
                            model.getGizmos().get(model.findGizmoIndex("RF4")).setGizmoActive(true);
                            //model.moveFlippers();
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
