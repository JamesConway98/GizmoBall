package Controller;

import model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunModeListener implements ActionListener {

    private Timer timer;
    private Model model;

    public RunModeListener(Model m) {
        model = m;
        timer = new Timer(20, this);
    }

    @Override
    public final void actionPerformed(final ActionEvent e) {

        if (e.getSource() == timer) {
            model.moveBall();
        } else switch (e.getActionCommand()) {
                case "Start":
                    timer.start();
                    break;
                case "Stop":
                    timer.stop();
                    break;
                case "Tick":
                    model.moveBall();
                    break;
                case "Quit":
                    System.exit(0);
                    break;
                case "Build Mode":
                    timer.stop();
                    break;
        }
    }

    public void stopTimer() {
        timer.stop();
    }
}
