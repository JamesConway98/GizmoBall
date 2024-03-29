package view;

import Controller.*;
import model.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class AddBuildPanel extends JPanel implements Observer {

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

    private JLabel addInitialXVelocityLabel;
    private JLabel addInitialYVelocityLabel;
    private JTextField initialXVelocityField;
    private JTextField initialYVelocityField;

    private Model model;

    private ArrayList<JButton> buttons;

    public AddBuildPanel(Model m){

        model = m;
        model.addObserver(this);

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

        ImageIcon square = new ImageIcon("Gizmoball/src/icons/square.png");
        addSquareButton = new JButton(square);
        addSquareButton.setActionCommand("Square");
        addSquareButton.setOpaque(false);
        addSquareButton.setContentAreaFilled(false);
        addSquareButton.setBorderPainted(false);
        addSquareButton.setToolTipText("Add a Square");
        buttons.add(addSquareButton);

        ImageIcon circle = new ImageIcon("Gizmoball/src/icons/circle.png");
        addCircleButton = new JButton(circle);
        addCircleButton.setBackground(Color.BLUE);
        addCircleButton.setActionCommand("Circle");
        addCircleButton.setOpaque(false);
        addCircleButton.setContentAreaFilled(false);
        addCircleButton.setBorderPainted(false);
        addCircleButton.setToolTipText("Add a Circle");
        buttons.add(addCircleButton);

        ImageIcon triangle = new ImageIcon("Gizmoball/src/icons/triangle.png");
        addTriangleButton = new JButton(triangle);
        addTriangleButton.setActionCommand("Triangle");
        addTriangleButton.setOpaque(false);
        addTriangleButton.setContentAreaFilled(false);
        addTriangleButton.setBorderPainted(false);
        addTriangleButton.setToolTipText("Add a Triangle");
        buttons.add(addTriangleButton);

        ImageIcon leftFlipper = new ImageIcon("Gizmoball/src/icons/leftFlipper.png");
        addLeftFlipperButton = new JButton(leftFlipper);
        addLeftFlipperButton.setActionCommand("Left Flipper");
        addLeftFlipperButton.setOpaque(false);
        addLeftFlipperButton.setContentAreaFilled(false);
        addLeftFlipperButton.setBorderPainted(false);
        addLeftFlipperButton.setToolTipText("Add Left Flipper");
        buttons.add(addLeftFlipperButton);

        ImageIcon rightFlipper = new ImageIcon("Gizmoball/src/icons/rightFlipper.png");
        addRightFlipperButton = new JButton(rightFlipper);
        addRightFlipperButton.setActionCommand("Right Flipper");
        addRightFlipperButton.setOpaque(false);
        addRightFlipperButton.setContentAreaFilled(false);
        addRightFlipperButton.setBorderPainted(false);
        addRightFlipperButton.setToolTipText("Add Right Flipper");
        buttons.add(addRightFlipperButton);

        ImageIcon ball = new ImageIcon("Gizmoball/src/icons/ball.png");
        addBallButton = new JButton(ball);
        addBallButton.setActionCommand("Ball");
        addBallButton.setOpaque(false);
        addBallButton.setContentAreaFilled(false);
        addBallButton.setBorderPainted(false);
        addBallButton.setToolTipText("Add Ball");
        buttons.add(addBallButton);

        ImageIcon absorber = new ImageIcon("Gizmoball/src/icons/absorber.png");
        addAbsorberButton = new JButton(absorber);
        addAbsorberButton.setActionCommand("Absorber");
        addAbsorberButton.setOpaque(false);
        addAbsorberButton.setContentAreaFilled(false);
        addAbsorberButton.setBorderPainted(false);
        addAbsorberButton.setToolTipText("Add Absorber");
        buttons.add(addAbsorberButton);

        for(JButton button: buttons){
            button.addActionListener(buildListener);
        }

        addInitialXVelocityLabel = new JLabel("Initial X Velocity:", SwingConstants.CENTER);
        addInitialXVelocityLabel.setFont(new Font(addInitialXVelocityLabel.getFont().getName(), addInitialXVelocityLabel.getFont().getStyle(), 15));
        addInitialYVelocityLabel = new JLabel("Initial Y Velocity:", SwingConstants.CENTER);
        addInitialYVelocityLabel.setFont(new Font(addInitialYVelocityLabel.getFont().getName(), addInitialYVelocityLabel.getFont().getStyle(), 15));

        initialXVelocityField = new JTextField(10);
        initialYVelocityField = new JTextField(10);

        ActionListener ballListener = new BallButtonListener(model, initialXVelocityField, initialYVelocityField);
        addBallButton.addActionListener(ballListener);

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
        add(addInitialXVelocityLabel, gc);

        gc.ipady = 20;
        gc.gridwidth = 2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(initialXVelocityField, gc);



        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 40;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(addInitialYVelocityLabel, gc);

        gc.ipady = 20;
        gc.gridwidth = 2;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(initialYVelocityField, gc);



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


    @Override
    public void update(Observable o, Object arg) {
        for(JButton button: buttons){
            button.setBorderPainted(false);
        }

        MouseListener l = model.getActiveMouseListener();

        //this highlights the current button
        if(l instanceof AddTriangleListener){
            addTriangleButton.setBorderPainted(true);
        }else if(l instanceof  AddCircleListener){
            addCircleButton.setBorderPainted(true);
        }else if(l instanceof  AddSquareListener){
            addSquareButton.setBorderPainted(true);
        }else if(l instanceof AddLeftFlipperListener){
            addLeftFlipperButton.setBorderPainted(true);
        }else if(l instanceof  AddRightFlipperListener){
            addRightFlipperButton.setBorderPainted(true);
        }else if(l instanceof  AddBallListener){
            addBallButton.setBorderPainted(true);
        }else if(l instanceof  AddAbsorberListener){
            addAbsorberButton.setBorderPainted(true);
        }

        revalidate();
        repaint();

    }
}
