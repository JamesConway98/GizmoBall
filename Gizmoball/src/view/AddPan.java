package view;

import javax.swing.*;
import java.awt.*;

public class AddPan {
    private JTabbedPane tabbedPane1;
    private JPanel AddPanel;
    private JPanel EditPanel;
    private JPanel SettingsPanel;
    private JButton circleButton;
    private JButton triangleButton;
    private JButton squareButton;
    private JButton leftFlipperButton;
    private JButton rightFlipperButton;
    private JLabel Flippers;
    private JTextField inVel;
    private JTextField inDir;
    private JButton ballButton;
    private JButton absorberButton;
    private JButton moveButton;
    private JButton rotateCCWButton;
    private JButton rotateCWButton;
    private JButton deleteButton;
    private JButton addConnectionButton;
    private JButton removeConnectionButton;
    private JButton addKeyConnectionButton;
    private JButton removeKeyConnectionButton;
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JButton button9;
    private JLabel gravLabel;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        tabbedPane1 = new JTabbedPane();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(tabbedPane1, gbc);
        AddPanel = new JPanel();
        AddPanel.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Untitled", AddPanel);
        circleButton = new JButton();
        circleButton.setText("Circle");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(circleButton, gbc);
        triangleButton = new JButton();
        triangleButton.setText("Triangle");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(triangleButton, gbc);
        squareButton = new JButton();
        squareButton.setText("Square");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(squareButton, gbc);
        Flippers = new JLabel();
        Flippers.setText("Flippers");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        AddPanel.add(Flippers, gbc);
        leftFlipperButton = new JButton();
        leftFlipperButton.setText("Left Flipper");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(leftFlipperButton, gbc);
        rightFlipperButton = new JButton();
        rightFlipperButton.setText("Right Flipper");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(rightFlipperButton, gbc);
        final JLabel label1 = new JLabel();
        label1.setText("Ball");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        AddPanel.add(label1, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Absorber");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AddPanel.add(label2, gbc);
        absorberButton = new JButton();
        absorberButton.setText("Absorber");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(absorberButton, gbc);
        inVel = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(inVel, gbc);
        inDir = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(inDir, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Initial Velocity");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AddPanel.add(label3, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Initial Direction");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        AddPanel.add(label4, gbc);
        ballButton = new JButton();
        ballButton.setText("Ball");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        AddPanel.add(ballButton, gbc);
        final JLabel label5 = new JLabel();
        label5.setHorizontalAlignment(0);
        label5.setHorizontalTextPosition(0);
        label5.setText("Bumper");
        label5.setVerticalAlignment(1);
        label5.setVerticalTextPosition(1);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        AddPanel.add(label5, gbc);
        EditPanel = new JPanel();
        EditPanel.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Untitled", EditPanel);
        moveButton = new JButton();
        moveButton.setText("Move");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EditPanel.add(moveButton, gbc);
        final JLabel label6 = new JLabel();
        label6.setHorizontalAlignment(0);
        label6.setHorizontalTextPosition(0);
        label6.setText("Rotate");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        EditPanel.add(label6, gbc);
        rotateCCWButton = new JButton();
        rotateCCWButton.setText("Rotate CCW");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EditPanel.add(rotateCCWButton, gbc);
        rotateCWButton = new JButton();
        rotateCWButton.setText("Rotate CW");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EditPanel.add(rotateCWButton, gbc);
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EditPanel.add(deleteButton, gbc);
        addConnectionButton = new JButton();
        addConnectionButton.setText("Add Connection");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EditPanel.add(addConnectionButton, gbc);
        removeConnectionButton = new JButton();
        removeConnectionButton.setText("Remove Connection");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EditPanel.add(removeConnectionButton, gbc);
        addKeyConnectionButton = new JButton();
        addKeyConnectionButton.setText("Add Key Connection");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EditPanel.add(addKeyConnectionButton, gbc);
        removeKeyConnectionButton = new JButton();
        removeKeyConnectionButton.setText("Remove Key Connection");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        EditPanel.add(removeKeyConnectionButton, gbc);
        SettingsPanel = new JPanel();
        SettingsPanel.setLayout(new GridBagLayout());
        tabbedPane1.addTab("Untitled", SettingsPanel);
        final JLabel label7 = new JLabel();
        label7.setText("Gravity");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        SettingsPanel.add(label7, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("Friction 1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        SettingsPanel.add(label8, gbc);
        final JLabel label9 = new JLabel();
        label9.setText("Friction 2");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        SettingsPanel.add(label9, gbc);
        slider1 = new JSlider();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SettingsPanel.add(slider1, gbc);
        final JLabel label10 = new JLabel();
        label10.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        SettingsPanel.add(label10, gbc);
        final JLabel label11 = new JLabel();
        label11.setText("MAX");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        SettingsPanel.add(label11, gbc);
        slider2 = new JSlider();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SettingsPanel.add(slider2, gbc);
        slider3 = new JSlider();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SettingsPanel.add(slider3, gbc);
        button9 = new JButton();
        button9.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SettingsPanel.add(button9, gbc);
        final JLabel label12 = new JLabel();
        label12.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        SettingsPanel.add(label12, gbc);
        final JLabel label13 = new JLabel();
        label13.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        SettingsPanel.add(label13, gbc);
        gravLabel = new JLabel();
        gravLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        SettingsPanel.add(gravLabel, gbc);
        final JLabel label14 = new JLabel();
        label14.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        SettingsPanel.add(label14, gbc);
        final JLabel label15 = new JLabel();
        label15.setText("MAX");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        SettingsPanel.add(label15, gbc);
        final JLabel label16 = new JLabel();
        label16.setText("MAX");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 7;
        SettingsPanel.add(label16, gbc);
        final JLabel label17 = new JLabel();
        label17.setText("0");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        SettingsPanel.add(label17, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weighty = 10.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        SettingsPanel.add(spacer1, gbc);
    }
}


