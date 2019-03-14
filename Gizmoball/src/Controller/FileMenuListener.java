package Controller;

import model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileMenuListener implements ActionListener {

    private Model model;

    public FileMenuListener(Model m) {
        model = m;
    }

    @Override
    public final void actionPerformed(final ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Load Configuration":
                model.loadGame();
                System.out.println("UIIHIHIH");
                break;
            case "Save Configuration":
                System.out.println("HIUHIHUI");
                model.saveGame();
                break;
            case "Save as":
                model.saveAs();
                break;
        }
    }

}
