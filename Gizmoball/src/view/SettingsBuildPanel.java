package view;

import Controller.*;
import model.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SettingsBuildPanel extends JPanel implements Observer {

    private JLabel gravityLabel;
    private JLabel friction1Label;
    private JLabel friction2Label;

    private JButton applySettingButton;

    private Scrollbar gravity;
    private Scrollbar friction1;
    private Scrollbar friction2;

    private Model model;

    public SettingsBuildPanel(Model m){
        this.model = m;
        this.model.addObserver(this);

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        gravity = new Scrollbar(Scrollbar.HORIZONTAL, (int) model.getGravity(), 64, 0, 164);
        friction1 = new Scrollbar(Scrollbar.HORIZONTAL, (int) model.getMu() * 1000, 64, 0, 164);
        friction2 = new Scrollbar(Scrollbar.HORIZONTAL, (int) model.getMu2() * 1000, 64, 0, 164);

        gravityLabel = new JLabel("Gravity:          " + model.getGravity() + "/sec" + '\u00B2');
        gravityLabel.setFont(new Font(gravityLabel.getFont().getName(), gravityLabel.getFont().getStyle(), 15));
        friction1Label = new JLabel("Friction one:          " + model.getMu() + " per sec");
        friction1Label.setFont(new Font(friction1Label.getFont().getName(), friction1Label.getFont().getStyle(), 15));
        friction2Label = new JLabel("Friction two:          " + model.getMu2() + " per L");
        friction2Label.setFont(new Font(friction2Label.getFont().getName(), friction2Label.getFont().getStyle(), 15));

        applySettingButton = new JButton("Apply Settings");

        gravity.addAdjustmentListener(new GravityListener(gravityLabel));
        friction1.addAdjustmentListener(new Friction1Listener(friction1Label));
        friction2.addAdjustmentListener(new Friction2Listener(friction2Label));

        applySettingButton.addActionListener(new BuildModeSettingsListener(model, gravityLabel, friction1Label, friction2Label));

        Border innerBorder = BorderFactory.createTitledBorder("Settings");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        formatLayout();
}

    public void formatLayout(){

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //---------------- ROW 1 ------------------------------------------------>
        gc.gridy = 0;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(25,0,0,0);
        add(gravityLabel, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(10,0,0,0);
        add(gravity, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;

        gc.insets = new Insets(25,0,0,0);
        add(friction1Label, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(10,0,0,0);
        add(friction1, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(25,0,0,0);
        add(friction2Label, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(10,0,0,0);
        add(friction2, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0;
        gc.weighty = 0.05;

        gc.ipady = 40;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(10,75,50,75);
        add(applySettingButton, gc);


    }

    @Override
    public void update(Observable o, Object arg) {
        gravity.setValue((int) model.getGravity());
        friction1.setValue((int) model.getMu() * 1000);
        friction2.setValue((int) model.getMu2() * 1000);
        gravityLabel.setText("Gravity:          " + model.getGravity() + "/sec" + '\u00B2');
        friction1Label.setText("Friction one:          " + model.getMu() + " per sec");
        friction2Label.setText("Friction two:          " + model.getMu2() + " per L");
        repaint();
    }
}
