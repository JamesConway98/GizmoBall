package view;

import Controller.BuildModeListener;
import model.Gizmos.Gizmo;
import model.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ChangeKeyPanel extends JPanel implements Observer {

    private JButton backButton, removeButton;
    private JLabel instructions, currentGizmoKey;
    private ArrayList<JButton> buttons;
    private Model model;

    public ChangeKeyPanel(Model m){

        model = m;
        m.addObserver(this);

        BuildModeListener buildListener = new BuildModeListener(m);
        buttons = new ArrayList<>();

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        instructions = new JLabel("Click on a Gizmo to select it.");
        currentGizmoKey = new JLabel();

        backButton = new JButton("Back");
        buttons.add(backButton);
        removeButton = new JButton("Remove");
        buttons.add(removeButton);

        for(JButton button: buttons){
            button.addActionListener(buildListener);
        }

        Border innerBorder = BorderFactory.createTitledBorder("Edit");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        formatLayout();
    }

    public void formatLayout() {

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //---------------- ROW 1 ------------------------------------------------>
        gc.gridy = 0;
        gc.ipady = 40;

        gc.weightx = 0.5;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridwidth = 2;
        gc.insets = new Insets(30,75,0,75);
        add(instructions, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 40;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,10);
        add(currentGizmoKey, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 40;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,10);
        add(removeButton, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 40;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,10);
        add(backButton, gc);

    }

    @Override
    public void update(Observable o, Object arg) {
        if(model.getSelectedGizmo()!=null) {
            Gizmo gizmo = model.getSelectedGizmo();
            instructions.setText("You have selected Gizmo " + gizmo.getID());
            currentGizmoKey.setText("Gizmo " + gizmo.getID() + " key = \"" + gizmo.getKey() + "\". Press a key to change this.");
        }else{
            instructions.setText("Click on a Gizmo to select it.");
            currentGizmoKey.setText("");
        }

        revalidate();
        repaint();
    }

}
