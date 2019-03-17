package view;

import Controller.BuildModeListener;
import Controller.Friction1Listener;
import Controller.Friction2Listener;
import Controller.GravityListener;
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

    Scrollbar gravity ;
    Scrollbar friction1;
    Scrollbar friction2;

    private ArrayList<JButton> buttons;

    Model model;

    public SettingsBuildPanel(Model m){
        this.model = m;
        this.model.addObserver(this);

        BuildModeListener buildListener = new BuildModeListener(model);
        buttons = new ArrayList<>();

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        gravity = new Scrollbar(Scrollbar.HORIZONTAL, (int) model.getGravity(), 64, 0, 164);
        friction1 = new Scrollbar(Scrollbar.HORIZONTAL, (int) model.getMu() * 100, 64, 0, 164);
        friction2 = new Scrollbar(Scrollbar.HORIZONTAL, (int) model.getMu2() * 100, 64, 0, 164);

        gravityLabel = new JLabel("Gravity:          " + this.model.getGravity() + "/sec" + '\u00B2');
        gravityLabel.setFont(new Font(gravityLabel.getFont().getName(), gravityLabel.getFont().getStyle(), 15));
        friction1Label = new JLabel("Friction1:          " + (int) model.getMu() + " per sec");
        friction1Label.setFont(new Font(friction1Label.getFont().getName(), friction1Label.getFont().getStyle(), 15));
        friction2Label = new JLabel("Friction2:          " + (int) model.getMu2() + " per L");
        friction2Label.setFont(new Font(friction2Label.getFont().getName(), friction2Label.getFont().getStyle(), 15));

        applySettingButton = new JButton("Apply Settings");
        buttons.add(applySettingButton);

        gravity.addAdjustmentListener(new GravityListener(model, gravityLabel));
        friction1.addAdjustmentListener(new Friction1Listener(model, friction1Label));
        friction2.addAdjustmentListener(new Friction2Listener(model, friction2Label));

        for(JButton button: buttons){
            button.addActionListener(buildListener);
        }

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
        friction1.setValue((int) model.getMu());
        friction2.setValue((int) model.getMu2());

        gravityLabel.setText("Gravity:          " + (int) model.getGravity() + "/sec" + '\u00B2');
        friction1Label.setText("Friction1:          " + (int) model.getMu() + " per sec");
        friction2Label.setText("Friction2:          " + (int) model.getMu2() + " per L");
        repaint();
    }

}
