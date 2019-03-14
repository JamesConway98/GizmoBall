package main;

import model.*;
import model.Gizmos.*;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        Model model = new Model();
        MainFrame frame = new MainFrame(model);
    }
}
