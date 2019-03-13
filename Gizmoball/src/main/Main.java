package main;

import model.*;
import model.Gizmos.*;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        model.addGizmo(new SquareGizmo("S1",2, 5));
        model.addGizmo(new CircleGizmo("C1",0, 0));
        MainFrame frame = new MainFrame(model);
    }
}
