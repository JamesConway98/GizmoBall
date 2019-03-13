package view;

import model.Model;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private RunBoard runBoard;
    private BuildBoard buildBoard;

    public MainFrame(Model m){
        JFrame frame = new JFrame("Gizmoball");
        frame.setLayout(new BorderLayout());

        // Board is passed the Model so it can act as Observer
        buildBoard = new BuildBoard(500, 500, m);
        runBoard = new RunBoard(500, 500, m);

        AddBuildPanel addBuildPanel = new AddBuildPanel(m);
        AddRunPanel addRunPanel = new AddRunPanel(m);


        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Add",addBuildPanel);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveConfiguration = new JMenuItem("Save Configuration");
        JMenuItem saveAs = new JMenuItem("Save as");
        JMenuItem loadConfiguration = new JMenuItem("Load Configuration");
        JMenuItem addRunMode = new JMenuItem("Run Mode");
        JMenuItem addBuildMode = new JMenuItem("Build Mode");
        addRunMode.addActionListener(actionEvent -> {
            frame.getContentPane().removeAll();
            frame.add(addRunPanel, BorderLayout.WEST);
            frame.add(runBoard, BorderLayout.CENTER);
            frame.revalidate();
            addRunMode.removeAll();
            fileMenu.remove(5);
            fileMenu.add(addBuildMode,5);
            runBoard.update(null, null);
        });
        addBuildMode.addActionListener(actionEvent -> {
            frame.getContentPane().removeAll();
            frame.add(tabbedPane, BorderLayout.WEST);
            frame.add(buildBoard, BorderLayout.CENTER);
            frame.revalidate();
            addRunMode.removeAll();
            fileMenu.remove(5);
            fileMenu.add(addRunMode,5);
            buildBoard.update(null, null);
        });
        JMenuItem quit = new JMenuItem("Quit");

        fileMenu.add(saveConfiguration);
        fileMenu.add(saveAs);
        fileMenu.addSeparator();
        fileMenu.add(loadConfiguration);
        fileMenu.addSeparator();
        fileMenu.add(addRunMode);
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
