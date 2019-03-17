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
        float newValue = adjustmentEvent.getValue();
        model.setMu1(newValue / 1000);
        friction1Label.setText("Friction1:          " + model.getMu() + " per sec");
    }
}
