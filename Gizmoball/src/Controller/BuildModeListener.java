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
                break;
            case "Right Flipper":
                AddRightFlipperListener rightFlipperListener = new AddRightFlipperListener(model);
                model.setMouseListener(rightFlipperListener);
                break;
            case "Ball":
                AddBallListener ballListener = new AddBallListener(model);
                model.setMouseListener(ballListener);
                break;
            case "Absorber":
                AddAbsorberListener absorberListener = new AddAbsorberListener(model);
                model.setMouseListener(absorberListener);
                break;
            case "Delete":
                DeleteGizmoListener deleteListener = new DeleteGizmoListener(model);
                model.setMouseListener(deleteListener);
                break;
            case "Rotate Clockwise":
                RotateGizmoListener rotateListener = new RotateGizmoListener(model, true);
                model.setMouseListener(rotateListener);
                break;
            case "Rotate Anti Clockwise":
                RotateGizmoListener rotateAntiListener = new RotateGizmoListener(model, false);
                model.setMouseListener(rotateAntiListener);
                break;
            case "Add Key Connection":
                AddKeyTriggerListener addKeyListener = new AddKeyTriggerListener(model);
                model.setMouseListener(addKeyListener);
                break;
            case "Back":
                model.setMouseListener(null);
                model.setSelectedGizmo(null);
                break;
            case "Quit":
                System.exit(0);
                break;
        }
    }

}
