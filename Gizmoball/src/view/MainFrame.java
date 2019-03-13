package view;

import Controller.FileMenuListener;
import model.Model;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private RunBoard runBoard;
    private BuildBoard buildBoard;
    private FileMenuListener menuListener;

    public MainFrame(Model m){
        JFrame frame = new JFrame("Gizmoball");
        frame.setLayout(new BorderLayout());

        // Board is passed the Model so it can act as Observer
        buildBoard = new BuildBoard(500, 500, m);
        runBoard = new RunBoard(500, 500, m);

        menuListener = new FileMenuListener(m);

        AddBuildPanel addBuildPanel = new AddBuildPanel(m);
        EditBuildPanel editBuildPanel = new EditBuildPanel(m);
        AddRunPanel addRunPanel = new AddRunPanel(m);
        SettingsBuildPanel settingsBuildPanel = new SettingsBuildPanel(m);


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Add",addBuildPanel);
        tabbedPane.addTab("Edit", editBuildPanel);
        tabbedPane.addTab("Settings", settingsBuildPanel);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveConfiguration = new JMenuItem("Save Configuration");
        saveConfiguration.addActionListener(menuListener);
        JMenuItem saveAs = new JMenuItem("Save as");
        saveAs.addActionListener(menuListener);
        JMenuItem loadConfiguration = new JMenuItem("Load Configuration");
        loadConfiguration.addActionListener(menuListener);
        JMenuItem changeToRunMode = new JMenuItem("Run Mode");
        JMenuItem changeToBuildMode = new JMenuItem("Build Mode");
        changeToRunMode.addActionListener(actionEvent -> {
            frame.getContentPane().removeAll();
            frame.add(addRunPanel, BorderLayout.WEST);
            frame.add(runBoard, BorderLayout.CENTER);
            frame.revalidate();
            changeToRunMode.removeAll();
            fileMenu.remove(5);
            fileMenu.add(changeToBuildMode,5);
            runBoard.update(null, null);
        });
        changeToBuildMode.addActionListener(actionEvent -> {
            frame.getContentPane().removeAll();
            frame.add(tabbedPane, BorderLayout.WEST);
            frame.add(buildBoard, BorderLayout.CENTER);
            frame.revalidate();
            changeToRunMode.removeAll();
            fileMenu.remove(5);
            fileMenu.add(changeToRunMode,5);
            //addRunPanel.getRunListener().stopTimer();
            //m.getBall().setExactX(ballXCoordinate);
            //m.getBall().setExactY(ballYCoordinate);
            buildBoard.update(null, null);
        });
        JMenuItem quit = new JMenuItem("Quit");

        fileMenu.add(saveConfiguration);
        fileMenu.add(saveAs);
        fileMenu.addSeparator();
        fileMenu.add(loadConfiguration);
        fileMenu.addSeparator();
        fileMenu.add(changeToRunMode);
        fileMenu.addSeparator();
        fileMenu.add(quit);

        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);

//        tabbedPane.addTab("Edit",addPanel2);
//        tabbedPane.addTab("Setting",addPanel3);

        frame.add(tabbedPane, BorderLayout.WEST);
        frame.add(buildBoard, BorderLayout.CENTER);

        frame.setSize(1300, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
