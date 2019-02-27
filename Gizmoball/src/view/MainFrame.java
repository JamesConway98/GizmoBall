package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame {

    public MainFrame(){
        JFrame frame = new JFrame("Gizmoball");

        frame.setLayout(new BorderLayout());

        TextPanel textPanel = new TextPanel();
        AddPanel addPanel = new AddPanel();

        frame.setJMenuBar((createMenuBar()));

        frame.add(addPanel, BorderLayout.WEST);
        frame.add(textPanel, BorderLayout.CENTER);

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
