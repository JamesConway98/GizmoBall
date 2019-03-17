package Controller;

import model.Model;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Friction1Listener implements AdjustmentListener {

    private Model model;
    private JLabel friction1Label;

    public Friction1Listener(Model m, JLabel fl) {
        model = m;
        friction1Label = fl;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        model.setMu1(adjustmentEvent.getValue());
        friction1Label.setText("Friction1:          " + (int) model.getMu() + " per sec");
    }
}
