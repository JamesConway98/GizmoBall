package view;

import Controller.BuildModeListener;
import model.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class AddBuildPanel extends JPanel {

    private JLabel bumperLabel;
    private JLabel flipperLabel;
    private JLabel ballLabel;
    private JLabel absorberLabel;

    private JButton addSquareButton;
    private JButton addCircleButton;
    private JButton addTriangleButton;
    private JButton addLeftFlipperButton;
    private JButton addRightFlipperButton;
    private JButton addBallButton;
    private JButton addAbsorberButton;
    private JButton rotateButton;
    private JButton deleteButton;
    private JButton addKeyTriggerButton;

    private JLabel addInitialVelocityLabel;
    private JLabel addInitialDirectionLabel;
    private JTextField initialVelocityField;
    private JTextField initialDirectionField;

    private ArrayList<JButton> buttons;

    public AddBuildPanel(Model m){

        BuildModeListener buildListener = new BuildModeListener(m);
        buttons = new ArrayList<>();

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        bumperLabel = new JLabel("Bumpers");
        flipperLabel = new JLabel("Flippers");
        ballLabel = new JLabel("Ball");
        absorberLabel = new JLabel("Absorber");

        addSquareButton = new JButton("Square");
        buttons.add(addSquareButton);
        addCircleButton = new JButton("Circle");
        buttons.add(addCircleButton);
        addTriangleButton = new JButton("Triangle");
        buttons.add(addTriangleButton);
        addLeftFlipperButton = new JButton("Left Flipper");
        buttons.add(addLeftFlipperButton);
        addRightFlipperButton = new JButton("Right Flipper");
        buttons.add(addRightFlipperButton);
        addBallButton = new JButton("Ball");
        buttons.add(addBallButton);
        addAbsorberButton = new JButton("Absorber");
        buttons.add(addAbsorberButton);
        rotateButton = new JButton("Rotate");
        buttons.add(rotateButton);
        deleteButton = new JButton("Delete");
        buttons.add(deleteButton);
        addKeyTriggerButton = new JButton("Add Key Trigger");
        buttons.add(deleteButton);

        for(JButton button: buttons){
            button.addActionListener(buildListener);
        }

        addInitialVelocityLabel = new JLabel("Initial Velocity: ");
        addInitialDirectionLabel = new JLabel("Initial Direction: ");
        initialVelocityField = new JTextField(10);
        initialDirectionField = new JTextField(10);

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
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.fill = GridBagConstraints.NONE;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(25,0,0,0);
        add(bumperLabel, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,0);
        add(addSquareButton, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,0);
        add(addCircleButton, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,10);
        add(addTriangleButton, gc);

        /////////////////// Next (Spacing) Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 3;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(new JLabel(), gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(flipperLabel, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        add(addLeftFlipperButton, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,0);
        add(addRightFlipperButton, gc);

        gc.gridx = 1;
        gc.gridy = 10;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(addKeyTriggerButton, gc);


        /////////////////// Next (Spacing) Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 3;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(new JLabel(), gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(ballLabel, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(addInitialVelocityLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(initialVelocityField, gc);



        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(addInitialDirectionLabel, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,5);
        add(initialDirectionField, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(10,0,0,5);
        add(addBallButton, gc);


        /////////////////// Next (Spacing) Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 3;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(new JLabel(), gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(30,0,0,5);
        add(absorberLabel, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(addAbsorberButton, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(rotateButton, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(deleteButton, gc);

    }


}
