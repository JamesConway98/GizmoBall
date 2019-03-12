package main;

import model.Ball;
import model.CircleGizmo;
import model.Model;
import model.SquareGizmo;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        model.addGizmo(new SquareGizmo(2, 5));
        model.addGizmo(new CircleGizmo(0, 0));
        MainFrame frame = new MainFrame(model);
    }
}
