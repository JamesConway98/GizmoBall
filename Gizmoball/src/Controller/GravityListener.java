package Controller;

import model.Model;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class GravityListener implements AdjustmentListener {

    private Model model;
    private JLabel gravityLabel;

    public GravityListener(Model m, JLabel gl) {
        model = m;
        gravityLabel = gl;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        model.setGravity(adjustmentEvent.getValue());
        gravityLabel.setText("Gravity:          " + adjustmentEvent.getValue() + "L/sec" + '\u00B2');
    }
}
