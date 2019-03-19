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

        ImageIcon playIcon = new ImageIcon("Gizmoball/src/icons/play.png");
        ImageIcon playText = new ImageIcon("Gizmoball/src/icons/Start.png");
        start = new JButton(playIcon);
        start.setActionCommand("Start");
        start.setOpaque(false);
        start.setContentAreaFilled(false);
        start.setBorderPainted(false);
        start.setRolloverEnabled(true);
        start.setRolloverIcon(playText);
        buttons.add(start);
        start.setFocusable(false);

        ImageIcon tickIcon = new ImageIcon("Gizmoball/src/icons/tick.png");
        ImageIcon tickText = new ImageIcon("Gizmoball/src/icons/tickText.png");
        tick = new JButton(tickIcon);
        tick.setActionCommand("Tick");
        tick.setOpaque(false);
        tick.setContentAreaFilled(false);
        tick.setBorderPainted(false);
        tick.setRolloverEnabled(true);
        tick.setRolloverIcon(tickText);
        buttons.add(tick);
        tick.setFocusable(false);

        ImageIcon stopIcon = new ImageIcon("Gizmoball/src/icons/stop.png");
        ImageIcon stopText = new ImageIcon("Gizmoball/src/icons/stopText.png");
        stop = new JButton(stopIcon);
        stop.setActionCommand("Stop");
        stop.setOpaque(false);
        stop.setContentAreaFilled(false);
        stop.setBorderPainted(false);
        stop.setRolloverEnabled(true);
        stop.setRolloverIcon(stopText);
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
