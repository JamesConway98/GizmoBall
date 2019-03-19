package Controller;

import model.Ball;
import model.Model;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static model.Model.L;

public class AddBallListener implements MouseListener {

    private Model model;
    private JTextField initialBallXVelocity;
    private JTextField initialBallYVelocity;

    public AddBallListener(Model m, JTextField ibxv, JTextField ibyv) {
        model = m;
        initialBallXVelocity = ibxv;
        initialBallYVelocity = ibyv;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int ballXVelocity = 0;
        int ballYVelocity = 0;
        int x = (e.getX());
        int y = (e.getY());
        if(x >= 50 + Ball.R && x <= (20*L) + 50 - Ball.R && y >= 50 + Ball.R && y <= 20*L+50 - Ball.R) {
            if(initialBallXVelocity.getText() != null) {
                String ballXVelocityString = initialBallXVelocity.getText().replaceAll("[^\\d-]", "");
                String tempString = ballXVelocityString.replaceAll("-", "");
                if(ballXVelocityString.startsWith("-")) {
                    ballXVelocityString = "-" + tempString;
                } else {
                    ballXVelocityString = tempString;
                }
                if(ballXVelocityString.length() != 0) {
                    ballXVelocity = Integer.parseInt(ballXVelocityString);
                    if(ballXVelocity > 100) {
                        ballXVelocity = 100;
                    }
                }
            }
            if(initialBallYVelocity.getText() != null) {
                String ballYVelocityString = initialBallYVelocity.getText().replaceAll("[^\\d-]", "");
                String tempString = ballYVelocityString.replaceAll("-", "");
                if(ballYVelocityString.startsWith("-")) {
                    ballYVelocityString = "-" + tempString;
                } else {
                    ballYVelocityString = tempString;
                }
                if(ballYVelocityString.length() != 0) {
                    ballYVelocity = Integer.parseInt(ballYVelocityString);
                    if(ballYVelocity > 100) {
                        ballYVelocity = 100;
                    }
                }
            }
            model.addBall(new Ball(x, y, ballXVelocity * L, ballYVelocity * L));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
