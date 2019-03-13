package view;

import Controller.BuildModeListener;
import model.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class SettingsBuildPanel extends JPanel {

    private JLabel gravityLabel;
    private JLabel friction1Label;
    private JLabel friction2Label;

    private JButton applySettingButton;

    Scrollbar gravity ;
    Scrollbar friction1;
    Scrollbar friction2;

    private ArrayList<JButton> buttons;

    public SettingsBuildPanel(Model m){

        BuildModeListener buildListener = new BuildModeListener(m);
        buttons = new ArrayList<>();

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        gravity = new Scrollbar(Scrollbar.HORIZONTAL, 0, 64, 0,255);
        friction1 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 64, 0,255);
        friction2 = new Scrollbar(Scrollbar.HORIZONTAL, 0, 64, 0,255);

        gravityLabel = new JLabel("Gravity:          25L/sec" + '\u2072');
        friction1Label = new JLabel("Friction1:          0.025 per sec");
        friction2Label = new JLabel("Friction2:          0.025 per L");

        applySettingButton = new JButton("Apply Settings");
        buttons.add(applySettingButton);

        for(JButton button: buttons){
            button.addActionListener(buildListener);
        }

        Border innerBorder = BorderFactory.createTitledBorder("Add Settings");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        formatLayout();
}

    public void formatLayout(){

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //---------------- ROW 1 ------------------------------------------------>
        gc.gridy = 0;

        gc.weightx = 0;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.NONE;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(25,0,0,0);
        add(gravityLabel, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,0);
        add(gravity, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(friction1Label, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(friction2Label, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(friction1, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(friction2, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(applySettingButton, gc);


    }


}
