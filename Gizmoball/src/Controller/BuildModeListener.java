package Controller;

import model.Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuildModeListener implements ActionListener {

    private Model model;

    public BuildModeListener(Model m) {
        model = m;
    }

    @Override
    public final void actionPerformed(final ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Square":
                AddSquareListener squareListener = new AddSquareListener(model);
                model.setMouseListener(squareListener);
                break;
            case "Circle":
                AddCircleListener circleListener = new AddCircleListener(model);
                model.setMouseListener(circleListener);
                break;
            case "Triangle":
                AddTriangleListener triangleListener = new AddTriangleListener(model);
                model.setMouseListener(triangleListener);
                break;
            case "Left Flipper":
                AddLeftFlipperListener leftFlipperListener = new AddLeftFlipperListener(model);
                model.setMouseListener(leftFlipperListener);
                System.out.println("BOOF");
                break;
            case "Right Flipper":
                AddRightFlipperListener rightFlipperListener = new AddRightFlipperListener(model);
                model.setMouseListener(rightFlipperListener);
                System.out.println("BOOF");
                break;
            case "Absorber":
                AddAbsorberListener absorberListener = new AddAbsorberListener(model);
                model.setMouseListener(absorberListener);
                break;
            case "Rotate":
                RotateGizmoListener rotateListener = new RotateGizmoListener(model);
                model.setMouseListener(rotateListener);
                break;
            case "Quit":
                System.exit(0);
                break;
        }
    }

}
