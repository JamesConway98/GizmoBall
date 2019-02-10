import javax.swing.UIManager;

import model.CircularGizmo;
import model.Model;
import model.SquareGizmo;
import model.TriangleGizmo;
import model.VerticalLine;
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
            System.out.println("Look and Feel error in Main");
        }

        Model model = new Model();

        model.setBallSpeed(200, 200);

        // Vertical line at (100,100), width 300
        model.addLine(new VerticalLine(100, 100, 300));
        model.addLine(new VerticalLine(100, 200, 300));
        model.addLine(new VerticalLine(100, 300, 300));
        model.addLine(new VerticalLine(100, 400, 300));

        model.addSquare(new SquareGizmo(250, 250));
        model.addSquare(new SquareGizmo(200, 200));
        model.addSquare(new SquareGizmo(350, 350));
        model.addSquare(new SquareGizmo(150, 150));

        model.addCircular(new CircularGizmo(100, 0));
        model.addCircular(new CircularGizmo(250, 300));
        model.addCircular(new CircularGizmo(400, 100));
        model.addCircular(new CircularGizmo(200, 450));

        model.addTriangle(new TriangleGizmo(200, 0, 1));
        model.addTriangle(new TriangleGizmo(300, 0, 3));
        model.addTriangle(new TriangleGizmo(400, 300, 4));
        RunGui gui = new RunGui(model);
        gui.createAndShowGUI();
    }
}
