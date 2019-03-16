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
        model.setFriction(model.getMu(), adjustmentEvent.getValue() / 100);
        friction1Label.setText("Friction2:          " + adjustmentEvent.getValue() + " per L");
    }
}