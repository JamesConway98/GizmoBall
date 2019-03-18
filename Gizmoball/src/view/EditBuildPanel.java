package view;

import Controller.*;
import model.Model;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class EditBuildPanel extends JPanel implements Observer {
    private JLabel rotateLabel;

    private JButton moveButton;
    private JButton leftRotateButton;
    private JButton rightRotateButton;
    private JButton deleteButton;
    private JButton addConnectionButton;
    private JButton editConnectionButton;
    private JButton editKeyConnectionButton;
    private JButton removeKeyConnectionButton;

    private Model model;

    private ArrayList<JButton> buttons;


    public EditBuildPanel(Model m){

        model = m;
        model.addObserver(this);

        BuildModeListener buildListener = new BuildModeListener(m);
        buttons = new ArrayList<>();

        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        rotateLabel = new JLabel("Rotate", SwingConstants.CENTER);
        rotateLabel.setFont(new Font(rotateLabel.getFont().getName(), rotateLabel.getFont().getStyle(), 15));

        moveButton = new JButton("Move");
        buttons.add(moveButton);

        ImageIcon leftRotate = new ImageIcon("Gizmoball/src/icons/rotateLeft.png");
        leftRotateButton = new JButton(leftRotate);
        leftRotateButton.setActionCommand("Rotate Anti Clockwise");
        leftRotateButton.setOpaque(false);
        leftRotateButton.setContentAreaFilled(false);
        leftRotateButton.setBorderPainted(false);
        buttons.add(leftRotateButton);

        ImageIcon rightRotate = new ImageIcon("Gizmoball/src/icons/rotateRight.png");
        rightRotateButton = new JButton(rightRotate);
        rightRotateButton.setActionCommand("Rotate Clockwise");
        rightRotateButton.setOpaque(false);
        rightRotateButton.setContentAreaFilled(false);
        rightRotateButton.setBorderPainted(false);
        buttons.add(rightRotateButton);

        deleteButton = new JButton("Delete");
        buttons.add(deleteButton);
        editConnectionButton = new JButton("Edit Connections");
        buttons.add(editConnectionButton);
        editKeyConnectionButton = new JButton("Edit Key Connections");
        buttons.add(editKeyConnectionButton);

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
        add(moveButton, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.gridwidth = 2;

        gc.weightx = 0.5;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(25,0,0,0);
        add(rotateLabel, gc);


        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 100;
        gc.gridwidth = 1;

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
        gc.weighty = 0;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridwidth = 2;
        gc.insets = new Insets(30,75,0,75);
        add(editConnectionButton, gc);

        /////////////////// Next Row ////////////////////////////
        gc.gridy++;
        gc.ipady = 50;
        gc.gridwidth = 1;

        gc.weightx = 0.5;
        gc.weighty = 0;

        gc.gridx = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridwidth = 2;
        gc.insets = new Insets(30,75,0,75);

        add(editKeyConnectionButton, gc);

    }


    @Override
    public void update(Observable o, Object arg) {

        //Un highlighting buttons

        rightRotateButton.setBorderPainted(false);
        leftRotateButton.setBorderPainted(false);

        for(JButton button:buttons){
            button.setForeground(Color.BLACK);
        }

        //green
        Color colour = new Color(0f,.8f,0f,1f );

        MouseListener l = model.getActiveMouseListener();

        //this highlights the current button
        if(l instanceof DeleteGizmoListener){
            deleteButton.setForeground(colour);
        }else if(l instanceof MoveGizmoListener){
            moveButton.setForeground(colour);
        } else if(l instanceof RotateGizmoListener){
            if(((RotateGizmoListener) l).getClockwise()) {
                rightRotateButton.setBorderPainted(true);
            }else{
                leftRotateButton.setBorderPainted(true);
            }
        }
    }
}
