package Controller;

import model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunModeListener implements ActionListener {

    private Model model;

    public RunModeListener(Model m) {
        model = m;
    }

    @Override
    public final void actionPerformed(final ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Start":
                model.getBall().start();
                break;
            case "Stop":
                model.getBall().stop();
                break;
            case "Tick":
                model.getBall().start();
                model.getBall().stop();
                break;
        }
    }

}
