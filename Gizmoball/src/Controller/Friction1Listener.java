package Controller;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Friction1Listener implements AdjustmentListener {

    private JLabel friction1Label;

    public Friction1Listener(JLabel fl) {
        friction1Label = fl;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        float newFriction1 = (float) adjustmentEvent.getValue() / 1000;
        friction1Label.setText("Friction one:          " + newFriction1 + " per sec");

    }
}
