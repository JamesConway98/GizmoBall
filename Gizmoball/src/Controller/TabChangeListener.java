package Controller;

import model.Model;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabChangeListener implements ChangeListener {

    private Model model;

    public TabChangeListener(Model m){
        model = m;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        model.setMouseListener(null);
        model.setSelectedGizmo(null);
    }
}
