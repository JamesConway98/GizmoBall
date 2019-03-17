package Controller;

import javax.swing.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class GravityListener implements AdjustmentListener {

    private JLabel gravityLabel;

    public GravityListener(JLabel gl) {
        gravityLabel = gl;
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
        gravityLabel.setText("Gravity:          " + adjustmentEvent.getValue() + "L/sec" + '\u00B2');
    }
}
