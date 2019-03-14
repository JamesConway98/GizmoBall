package test;

import model.*;
import model.Gizmos.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class gizmoBallTests {

    Model model = new Model();

    @org.junit.BeforeClass
    public static void beforeClassSetup (){ }

    @org.junit.Before
    public void beforeSetup(){ }

    @org.junit.Test
    public void addGizmoTest(){
        assertEquals(model.getGizmo().size(), 0);

        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);

        Gizmo triangle = new TriangleGizmo("T1",7,7);
        model.addGizmo(triangle);
        assertEquals(model.getGizmo().size(), 2);

        Gizmo circle = new CircleGizmo("C1",9,9);
        model.addGizmo(circle);
        assertEquals(model.getGizmo().size(), 3);

    }

    @org.junit.Test
    public void addGizmoToOccupiedLocationTest(){
        Gizmo square = new SquareGizmo("S1",5,5);
        Gizmo triangle = new SquareGizmo("S2",5,5);
        assertEquals(model.getGizmo().size(), 0);

        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);
        assertEquals(model.getGizmo().get(0), "SquareGizmo55");

        model.addGizmo(triangle);
        assertEquals(model.getGizmo().size(), 1);
        assertEquals(model.getGizmo().get(0), "SquareGizmo55");
    }

    @org.junit.Test
    public void addGizmoToLocationOutsideOfBoardTest(){
        Gizmo square = new SquareGizmo("S1",-5,-5);
        assertEquals(model.getGizmo().size(), 0);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 0);
    }

    @org.junit.Test
    public void moveGizmoTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);
        //model.moveGizmoMethod(square, NewXCoord, NewYCoord);
        //assertEquals(square.getX(), NewXCoord);
        //assertEquals(square.getY(), NewYCoord);
        fail();
    }

    @org.junit.Test
    public void moveGizmoToOccupiedLocationTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S1",5,5);
        Gizmo square2 = new SquareGizmo("S2",7,7);
        model.addGizmo(square);
        model.addGizmo(square2);
        assertEquals(model.getGizmo().size(), 2);
        //model.moveGizmoMethod(square, 7, 7);
        assertEquals(model.getGizmo().size(), 2);
        //assertEquals(square.getX(), 5);
        //assertEquals(square.getY(), 5);

        //assertEquals(square2.getX(), 7);
        //assertEquals(square2.getY(), 7);
        fail();
    }

    @org.junit.Test
    public void moveGizmoToLocationOutsideOfBoardTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);
        //model.moveGizmoMethod(square, -5, -5);
        assertEquals(model.getGizmo().size(), 1);
        //assertEquals(square.getX(), 5);
        //assertEquals(square.getY(), 5);
        fail();
    }

    @org.junit.Test
    public void deleteGizmoTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S2",5,5);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);
        //model.removeGizmoMethod(identifierForGizmo);
        //assertEquals(model.getGizmo().size(), 0);
        fail();
    }

    @org.junit.Test
    public void deleteNonExistingGizmoTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);
        //model.removeGizmoMethod(BogusGizmo);
        assertEquals(model.getGizmo().size(), 1);
        fail();
    }

    @org.junit.Test
    public void rotateGizmoTest() {
        Gizmo triangle = new TriangleGizmo("T1",5,5);
        model.addGizmo(triangle);
        assertEquals(triangle.getRotation(), 0);
        triangle.rotateClockwise();
        assertEquals(triangle.getRotation(), 1);
        triangle.rotateClockwise();
        assertEquals(triangle.getRotation(), 2);
        triangle.rotateClockwise();
        assertEquals(triangle.getRotation(), 3);
        triangle.rotateClockwise();
        assertEquals(triangle.getRotation(), 0);
    }

    @org.junit.Test
    public void rotateGizmoAntiClockWiseTest() {
        Gizmo triangle = new TriangleGizmo("T1",5,5);
        model.addGizmo(triangle);
        assertEquals(triangle.getRotation(), 0);
        triangle.rotateAnticlockwise();
        assertEquals(triangle.getRotation(), 3);
        triangle.rotateAnticlockwise();
        assertEquals(triangle.getRotation(), 2);
        triangle.rotateAnticlockwise();
        assertEquals(triangle.getRotation(), 1);
        triangle.rotateAnticlockwise();
        assertEquals(triangle.getRotation(), 0);
    }

    @org.junit.Test
    public void addConnectionTest() {
        Gizmo square = new SquareGizmo("S1",5,5);
        Gizmo square2 = new SquareGizmo("S2",10,10);
        model.addGizmo(square);
        model.addGizmo(square2);
        //assertFalse(square.hasConnection());
        //model.connectGizmoMethod(square, square2);
        //assertTrue(square.hasConnection());
        fail();
    }

    @org.junit.Test
    public void removeConnectionTest() {
        Gizmo square = new SquareGizmo("S1",5,5);
        Gizmo square2 = new SquareGizmo("S2",10,10);
        model.addGizmo(square);
        model.addGizmo(square2);
        //assertFalse(square.hasConnection());
        //model.connectGizmoMethod(square, square2);
        //assertTrue(square.hasConnection());
        //model.removeConnectionMethod(square, square2);
        //assertFalse(square.hasConnection());
        fail();
    }

    @org.junit.Test
    public void addkeyConnectionTest() {
        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        //assertFalse(square.hasKeyConnection());
        //model.addKeyConnectionMethod(square, key);
        //assertTrue(square.hasKeyConnection());
        fail();
    }

    @org.junit.Test
    public void removeKeyConnectionTest() {
        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        //assertFalse(square.hasKeyConnection());
        //model.addKeyConnectionMethod(square, key);
        //assertTrue(square.hasKeyConnection());
        //model/removeKeyConnectionMethod(square);
        //assertFalse(triangle.hasKeyConnections());
        fail();
    }

    @org.junit.Test
    public void addBallTest() {
        // assertNull(model.getBall());
        // model.addBallMethod(x , y, )
        // assertNotNull(model.getBall());
    }

    @org.junit.Test
    public void addBallToOccupiedLocationTest() {
        Gizmo square = new SquareGizmo("S1",5 , 5);
        // assertNull(model.getBall());
        // model.addBallMethod(x , y, )
        // assertNotNull(model.getBall());
    }

    @org.junit.Test
    public void saveTest() {

    }

    @org.junit.Test
    public void invalidSaveTest() {

    }

    @org.junit.Test
    public void loadTest() {

    }

    @org.junit.Test
    public void invalidLoadTest() {

    }

    @org.junit.Test
    public void resetTest() {

    }

}
