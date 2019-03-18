package view;

import Controller.*;
import model.GameLoader;
import model.Model;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class MainFrame implements Observer {

    private RunBoard runBoard;
    private BuildBoard buildBoard;
    private Model model;
    private JTabbedPane tabbedPane;
    private ChangeKeyPanel changeKeyPanel;
    private EditBuildPanel editBuildPanel;
    private SettingsBuildPanel settingsBuildPanel;
    private JFrame frame;
    private MoveMouseListener moveMouseListener;

    public MainFrame(Model m){

        model = m;

        frame = new JFrame("Gizmoball");
        frame.setLayout(new BorderLayout());

        // Board is passed the Model so it can act as Observer
        buildBoard = new BuildBoard(500, 500, m);
        runBoard = new RunBoard(500, 500, m);

        GameLoader loader = new GameLoader();
        File file = new File("BoardSave.txt");
        loader.loadGame(m, file);
        buildBoard.update(null, null);

        FileMenuListener menuListener = new FileMenuListener(m);
        TabChangeListener tabListener = new TabChangeListener(m);
        moveMouseListener = new MoveMouseListener(m);

        buildBoard.addMouseMotionListener(moveMouseListener);

        AddBuildPanel addBuildPanel = new AddBuildPanel(m);
        editBuildPanel = new EditBuildPanel(m);
        changeKeyPanel = new ChangeKeyPanel(m);
        AddRunPanel addRunPanel = new AddRunPanel(m);
        settingsBuildPanel = new SettingsBuildPanel(m);


        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Add",addBuildPanel);
        tabbedPane.addTab("Edit", editBuildPanel);
        tabbedPane.addTab("Settings", settingsBuildPanel);
        tabbedPane.addChangeListener(tabListener);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setFocusable(false);
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
            addRunPanel.getRunListener().stopTimer();
            loader.loadGame(m, file);
            buildBoard.update(null, null);
        });
        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(menuListener);

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

        frame.add(tabbedPane, BorderLayout.WEST);
        frame.add(buildBoard, BorderLayout.CENTER);

        frame.setSize(1300, 900);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        model.addObserver(this);

    }

    public void setEditKeyPanel(){
        tabbedPane.setComponentAt(1, changeKeyPanel);
        frame.revalidate();
        frame.repaint();
    }

    public void setDefaultEditPanel(){
        tabbedPane.setComponentAt(1, editBuildPanel);
        frame.revalidate();
        frame.repaint();
    }

    @Override
    public void update(Observable o, Object arg) {
        if(model.getActiveMouseListener() instanceof EditKeyTriggerListener){
            setEditKeyPanel();
        }else{
            setDefaultEditPanel();
        }

        if(model.getActiveMouseListener() instanceof MoveGizmoListener){
            moveMouseListener.addObserver((MoveGizmoListener)model.getActiveMouseListener());
        }else if(model.getActiveMouseListener() instanceof AddAbsorberListener){
            moveMouseListener.addObserver((AddAbsorberListener)model.getActiveMouseListener());
        }
    }
}
