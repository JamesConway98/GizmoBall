package Controller;

import model.Model;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Friction2Listener implements AdjustmentListener {

    private Model model;
    private JLabel friction1Label;

    public Friction2Listener(Model m, JLabel f2) {
        model = m;
        friction1Label = f2;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        float newValue = adjustmentEvent.getValue();
        model.setMu2(newValue / 1000);
        friction1Label.setText("Friction2:          " + model.getMu2() + " per L");
    }
}