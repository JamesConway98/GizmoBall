package view;

import Controller.AddSquareListener;
import model.Model;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private BuildBoard buildBoard;
    protected AddSquareListener addSquareListener;

    public MainFrame(Model m){
        JFrame frame = new JFrame("Gizmoball");
        frame.setLayout(new BorderLayout());

        addSquareListener = new AddSquareListener(m);

        // Board is passed the Model so it can act as Observer
        buildBoard = new BuildBoard(500, 500, m);
        buildBoard.addMouseListener(addSquareListener);

        AddPanel addPanel = new AddPanel();

        frame.setJMenuBar((createMenuBar()));

        frame.add(addPanel, BorderLayout.WEST);
        frame.add(buildBoard, BorderLayout.CENTER);

        frame.setSize(1300, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveConfiguration = new JMenuItem("Save Configuration");
        JMenuItem saveAs = new JMenuItem("Save as");
        JMenuItem loadConfiguration = new JMenuItem("Load Configuration");
        JMenuItem runMode = new JMenuItem("Run Mode");
        JMenuItem quit = new JMenuItem("Quit");

        fileMenu.add(saveConfiguration);
        fileMenu.add(saveAs);
        fileMenu.addSeparator();
        fileMenu.add(loadConfiguration);
        fileMenu.addSeparator();
        fileMenu.add(runMode);
        fileMenu.addSeparator();
        fileMenu.add(quit);

        menuBar.add(fileMenu);

        return menuBar;
    }
}
