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

        bumperLabel = new JLabel("Bumpers", SwingConstants.CENTER);
        bumperLabel.setFont(new Font(bumperLabel.getFont().getName(), bumperLabel.getFont().getStyle(), 15));
        flipperLabel = new JLabel("Flippers", SwingConstants.CENTER);
        flipperLabel.setFont(new Font(flipperLabel.getFont().getName(), flipperLabel.getFont().getStyle(), 15));
        ballLabel = new JLabel("Ball", SwingConstants.CENTER);
        ballLabel.setFont(new Font(ballLabel.getFont().getName(), ballLabel.getFont().getStyle(), 15));
        absorberLabel = new JLabel("Absorbers", SwingConstants.CENTER);
        absorberLabel.setFont(new Font(absorberLabel.getFont().getName(), absorberLabel.getFont().getStyle(), 15));

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

        for(JButton button: buttons){
            button.addActionListener(buildListener);
        }

        addInitialVelocityLabel = new JLabel("Initial Velocity:", SwingConstants.CENTER);
        addInitialVelocityLabel.setFont(new Font(addInitialVelocityLabel.getFont().getName(), addInitialVelocityLabel.getFont().getStyle(), 15));
        addInitialDirectionLabel = new JLabel("Initial Direction:", SwingConstants.CENTER);
        addInitialDirectionLabel.setFont(new Font(addInitialDirectionLabel.getFont().getName(), addInitialDirectionLabel.getFont().getStyle(), 15));

        initialVelocityField = new JTextField(10);
        initialDirectionField = new JTextField(10);

        Border innerBorder = BorderFactory.createTitledBorder("Add");
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

        gc.gridx = 1;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(25,0,0,0);
        add(bumperLabel, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 40;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0.5;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,10);
        add(addSquareButton, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(addCircleButton, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,10);
        add(addTriangleButton, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(flipperLabel, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,10,0,0);
        add(addLeftFlipperButton, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,10);
        add(addRightFlipperButton, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(ballLabel, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(addInitialVelocityLabel, gc);

        gc.ipady = 20;
        gc.gridwidth = 2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(initialVelocityField, gc);



        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 40;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(addInitialDirectionLabel, gc);

        gc.ipady = 20;
        gc.gridwidth = 2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(initialDirectionField, gc);



        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.gridwidth = 1;
        gc.ipady = 40;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(addBallButton, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(absorberLabel, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;

        gc.weightx = 0.5;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(addAbsorberButton, gc);


    }


}
