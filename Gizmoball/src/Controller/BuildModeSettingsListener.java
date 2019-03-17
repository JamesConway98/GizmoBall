package Controller;

import model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildModeSettingsListener implements ActionListener {

    private Model model;
    private JLabel gravity;
    private JLabel friction1;
    private JLabel friction2;

    public BuildModeSettingsListener(Model m, JLabel g, JLabel f1, JLabel f2) {
        model = m;
        gravity = g;
        friction1 = f1;
        friction2 = f2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        model.setGravity(Float.parseFloat(gravity.getText().replaceAll("\\D+", "")));
        model.setFriction(Float.parseFloat(friction1.getText().replaceAll("\\D+", "")) / 1000, Float.parseFloat(friction2.getText().replaceAll("\\D+", "")) / 1000);
    }
}
