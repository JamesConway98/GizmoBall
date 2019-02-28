package Main;

import javax.swing.UIManager;

import model.*;
import view.RunGui;

/**
 * @author Murray Wood Demonstration of MVC and MIT Physics Collisions 2014
 */

public class Main {

    public static void main(String[] args) {
        try {
            // Use the platform look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Look and Feel error in Main.Main");
        }

        Model model = new Model();

        model.setBallSpeed(200, 200);

        Gizmo T1 = new TriangleGizmo(0, 0);
        T1.rotateClockwise();
        
//        // Vertical line at (100,100), width 300
//        model.addLine(new VerticalLine(100, 100, 300));
//        model.addLine(new VerticalLine(100, 200, 300));
//        model.addLine(new VerticalLine(100, 300, 300));
//        model.addLine(new VerticalLine(100, 400, 300));
//
//        model.addGizmo(new SquareGizmo(250, 250));
//        model.addGizmo(new SquareGizmo(350, 350));
//        model.addGizmo(new SquareGizmo(200, 150));
//
//        model.addGizmo(new CircleGizmo(100, 0));
//        model.addGizmo(new CircleGizmo(250, 300));
//        model.addGizmo(new CircleGizmo(400, 100));
//        model.addGizmo(new CircleGizmo(200, 450));
//
//        model.addGizmo(new TriangleGizmo(250,100));
//        model.addGizmo(new TriangleGizmo(250,0));
//
//        model.addGizmo(new TriangleGizmo(450,0));
//        model.addGizmo(new TriangleGizmo(0,100));
//        model.addGizmo(new TriangleGizmo(450,450));
//
      model.addGizmo(new LeftFlipperGizmo(200, 200, 0));
      model.addGizmo(new RightFlipperGizmo(200, 200, 0));
//
//        model.addGizmo(new Absorber(100, 400, 400, 410));

        RunGui gui = new RunGui(model);
        gui.createAndShowGUI();
    }
}
