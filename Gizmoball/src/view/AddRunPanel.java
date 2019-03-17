package view;

import Controller.RunModeListener;
import model.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class AddRunPanel extends JPanel {
    private JButton start;
    private JButton tick;
    private JButton stop;
    private RunModeListener runListener;
    private ArrayList<JButton> buttons;

    public RunModeListener getRunListener() {
        return runListener;
    }

    public AddRunPanel(Model m){

        runListener = new RunModeListener(m);
        buttons = new ArrayList<>();

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        this.setFocusable(false);

        start = new JButton("Start");
        buttons.add(start);
        start.setFocusable(false);
        tick = new JButton("Tick");
        buttons.add(tick);
        tick.setFocusable(false);
        stop = new JButton("Stop");
        buttons.add(stop);
        stop.setFocusable(false);

        for(JButton button: buttons){
            button.addActionListener(runListener);
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

        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,0);
        add(start, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,0);
        add(tick, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,0);
        add(stop, gc);
    }
}