package model.Gizmos;

public interface Flipper extends Gizmo {
    public double getAngle();
    public void setAngle(double angle);
    public boolean isGizmoMoving();
    public void setGizmoMoving(boolean gizmoIsMoving);
    public boolean getMoveToggle();
    public void flipMoveToggle();
}
