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

public class ChangeConnectionPanel extends JPanel implements Observer {
    private JButton backButton, removeButton;
    private JLabel instructions, currentGizmoConnection;
    private ArrayList<JButton> buttons;
    private Model model;

    public ChangeConnectionPanel(Model m){

        model = m;
        model.addObserver(this);

        BuildModeListener buildListener = new BuildModeListener(m);
        buttons = new ArrayList<>();

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        instructions = new JLabel("Click on a Gizmo to select it.");
        currentGizmoConnection = new JLabel();

        backButton = new JButton("Back");
        buttons.add(backButton);
        removeButton = new JButton("Remove Connection");
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
        add(currentGizmoConnection, gc);

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
            currentGizmoConnection.setText("<html>Gizmo " + gizmo.getID() + " connection = \"" + gizmo.getConnection() + "\"." +
                    "<br> Click on a flipper to change this," +
                    "<br>Or click another gizmo to select it.</html>");
        }else{
            instructions.setText("Click on a Gizmo to select it.");
            currentGizmoConnection.setText("");
        }
        revalidate();
        repaint();
    }
}
