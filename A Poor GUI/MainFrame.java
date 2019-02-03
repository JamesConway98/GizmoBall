import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame  {

    private TextPanel textPanel;
    private AddPanel addPanel;

    public MainFrame(){
        JFrame frame = new JFrame("CollisionPrototype");

        frame.setLayout(new BorderLayout());

        textPanel= new TextPanel();
        addPanel = new AddPanel();

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

        //Mnemonics
        fileMenu.setMnemonic(KeyEvent.VK_F);
        quit.setMnemonic(KeyEvent.VK_Q);

        //Shortcut key to exit game
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return menuBar;
    }
}
