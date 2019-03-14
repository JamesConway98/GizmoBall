package view;

import Controller.BuildModeListener;
import model.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class EditBuildPanel extends JPanel {
    private JLabel rotateLabel;

    private JButton moveButton;
    private JButton leftRotateButton;
    private JButton rightRotateButton;
    private JButton deleteButton;
    private JButton addConnectionButton;
    private JButton removeConnectionButton;
    private JButton addKeyConnectionButton;
    private JButton removeKeyConnectionButton;

    private ArrayList<JButton> buttons;

    public EditBuildPanel(Model m){

        BuildModeListener buildListener = new BuildModeListener(m);
        buttons = new ArrayList<>();

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        rotateLabel = new JLabel("Rotate");

        moveButton = new JButton("Move");
        buttons.add(moveButton);
        leftRotateButton = new JButton("Rotate left");
        buttons.add(leftRotateButton);
        rightRotateButton = new JButton("Rotate Right");
        buttons.add(rightRotateButton);
        deleteButton = new JButton("Delete");
        buttons.add(deleteButton);
        addConnectionButton = new JButton("Add Connection");
        buttons.add(addConnectionButton);
        removeConnectionButton = new JButton("Remove Connection");
        buttons.add(removeConnectionButton);
        addKeyConnectionButton = new JButton("Add Key Connection");
        buttons.add(addKeyConnectionButton);
        removeKeyConnectionButton = new JButton("Remove Key Connection");
        buttons.add(removeConnectionButton);

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
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridwidth = 2;
        gc.insets = new Insets(25,75,0,75);
        add(moveButton, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(25,0,0,0);
        add(rotateLabel, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 100;

        gc.weightx = 0.5;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(leftRotateButton, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0,0,0);
        add(rightRotateButton, gc);


//        /////////////////// Next Row ////////////////////////////

        gc.gridy++;
        gc.ipady = 40;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridwidth = 2;
        gc.insets = new Insets(25,75,0,75);
        add(deleteButton, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 50;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(addConnectionButton, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0,0,0);
        add(removeConnectionButton, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 50;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(addKeyConnectionButton, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0,0,0);
        add(removeKeyConnectionButton, gc);

    }

}
