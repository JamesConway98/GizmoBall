package test;

import model.*;
import model.Gizmos.*;

import static junit.framework.TestCase.assertNotNull;
import static model.Model.L;
import static org.junit.Assert.*;

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
        assertTrue(square.getGridX()>0);
        assertTrue(square.getGridY()>0);
    }

    @org.junit.Test
    public void moveGizmoTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);
        model.moveGizmo(square, 10, 10);
        assertEquals(square.getGridX(), 10);
        assertEquals(square.getGridY(), 10);
    }

    @org.junit.Test
    public void moveGizmoToOccupiedLocationTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S1",5,5);
        Gizmo square2 = new SquareGizmo("S2",7,7);
        model.addGizmo(square);
        model.addGizmo(square2);
        assertEquals(model.getGizmo().size(), 2);
        model.moveGizmo(square, 7, 7);
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
        model.moveGizmo(square, -5, -5);
        assertEquals(model.getGizmo().size(), 1);
        assertNotEquals(square.getGridX(), -5);
        assertNotEquals(square.getGridY(), -5);
    }

    @org.junit.Test
    public void deleteGizmoTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S2",5,5);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);
        model.removeGizmo(square);
        assertEquals(model.getGizmo().size(), 0);
    }

    @org.junit.Test
    public void deleteNonExistingGizmoTest() {
        assertEquals(model.getGizmo().size(), 0);
        Gizmo square = new SquareGizmo("S1",5,5);
        Gizmo circle = new CircleGizmo("S1",5,5);
        model.addGizmo(square);
        assertEquals(model.getGizmo().size(), 1);
        model.removeGizmo(circle);
        assertEquals(model.getGizmo().size(), 1);
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
        Gizmo leftFlip = new LeftFlipperGizmo("LF2",10,10);
        model.addGizmo(square);
        model.addGizmo(leftFlip);
        assertTrue(square.getConnection()==null);
        model.setSelectedGizmo(square);
        model.addConnection(leftFlip);
        assertEquals(square.getConnection(), "LF2");
    }

    @org.junit.Test
    public void removeConnectionTest() {
        Gizmo square = new SquareGizmo("S1",5,5);
        Gizmo leftFlip = new LeftFlipperGizmo("LF2",10,10);
        model.addGizmo(square);
        model.addGizmo(leftFlip);
        assertTrue(square.getConnection()==null);
        model.setSelectedGizmo(square);
        model.addConnection(leftFlip);
        assertEquals(square.getConnection(), "LF2");
        model.removeConnection(square);
        assertTrue(square.getConnection() == null);
    }

    @org.junit.Test
    public void addkeyConnectionTest() {
        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        assertTrue(square.getKey()== Character.MIN_VALUE); //char equals null
        model.setSelectedGizmo(square);
        model.setKeyToSelectedObject('k');
        assertEquals(square.getKey(), 'k');
    }

    @org.junit.Test
    public void removeKeyConnectionTest() {
        Gizmo square = new SquareGizmo("S1",5,5);
        model.addGizmo(square);
        assertTrue(square.getKey()== Character.MIN_VALUE); //char equals null
        model.setSelectedGizmo(square);
        model.setKeyToSelectedObject('k');
        model.removeKey(square);
        assertTrue(square.getKey()== Character.MIN_VALUE); //char equals null
    }

    @org.junit.Test
    public void addBallTest() {
        Ball ball = new Ball(300 , 200, 0.0, 0.0);
        assertNull(model.getBall());
        model.addBall(ball);
        assertNotNull(model.getBall());
    }

    @org.junit.Test
    public void addBallToOccupiedLocationTest() {
        int x = 5, y=5;
        Gizmo square = new SquareGizmo("S1",x , y);
        assertNull(model.getBall());
        Ball ball = new Ball(x*L+50 , y*L+50, 0.0, 0.0);
        model.addBall(ball);
        assertNotNull(model.getBall());
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
