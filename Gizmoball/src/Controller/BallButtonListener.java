package Controller;

import model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BallButtonListener implements ActionListener {

    private Model model;
    private JTextField initialBallXVelocity;
    private JTextField initialBallYVelocity;

    public BallButtonListener(Model m, JTextField ibxv, JTextField ibyv) {
        model = m;
        initialBallXVelocity = ibxv;
        initialBallYVelocity = ibyv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setMouseListener(new AddBallListener(model, initialBallXVelocity, initialBallYVelocity));
    }
}
