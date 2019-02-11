package model;
import java.awt.Color;
import physics.Circle;
import physics.LineSegment;
import physics.Vect;

public class CircleGizmo extends Gizmo {
    private Vect v1;
    private Circle c1;


    public CircleGizmo(int x, int y){
        super(x, y);
        setColour(Color.GREEN);
        //Value for L
        int L = getLength();

        v1 = new Vect(x + L/2, y + L/2);

        c1 = new Circle(v1, L/2);

        getVertices().add(c1);
    }
}