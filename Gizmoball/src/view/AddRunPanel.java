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

        ImageIcon play = new ImageIcon("Gizmoball/src/icons/play.png");
        start = new JButton("Start");
        start.setRolloverEnabled(true);
        start.setRolloverIcon(play);
        buttons.add(start);
        start.setFocusable(false);

        ImageIcon tickk = new ImageIcon("Gizmoball/src/icons/tick.png");
        tick = new JButton("Tick", tickk);
        buttons.add(tick);
        tick.setFocusable(false);

        ImageIcon stopp = new ImageIcon("Gizmoball/src/icons/stop.png");
        stop = new JButton("Stop", stopp);
        buttons.add(stop);
        stop.setFocusable(false);

        for(JButton button: buttons){
            button.addActionListener(runListener);
        }

        Border innerBorder = BorderFactory.createTitledBorder("Run Settings");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        formatLayout();
    }

    public void formatLayout(){

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //---------------- ROW 1 ------------------------------------------------>
        gc.gridy = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = 40;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,30,0,30);
        add(start, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,30,0,30);
        add(tick, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,30,0,30);
        add(stop, gc);
    }
}
