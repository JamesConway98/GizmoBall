package Controller;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class Friction2Listener implements AdjustmentListener {

    private JLabel friction1Label;

    public Friction2Listener(JLabel f2) {
        friction1Label = f2;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        float newFriction2 = (float) adjustmentEvent.getValue() / 1000;
        friction1Label.setText("Friction two:          " + newFriction2 + " per L");
    }
}