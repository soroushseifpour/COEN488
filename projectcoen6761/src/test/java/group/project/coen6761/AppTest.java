package group.project.coen6761;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import group.project.coen6761.Robot.Direction;
/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	static Room iRoom; 
	static Robot iRobot;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		iRoom = new Room(5);
		iRobot= new Robot();
		App.robot=iRobot;
		App.room=iRoom;
	}
	@Test
	void testMove() {
		
		iRobot.setPenDown();
		iRobot.direction=Direction.East;
		iRobot.setXY(0, 0);
        
        // Test moving in the East direction
	    App.move("3"); // Move 3 spaces to the right
	    System.out.println("Room after moving east:");
	    iRoom.print(); // Print the room to see the updated values
        assertEquals(1, iRoom.room[4][3]); // Check if the robot left a trail in the room
        assertEquals(3, iRobot.x); // Check if the robot's X coordinate is updated correctly
        assertEquals(0, iRobot.y); // Check if the robot's Y coordinate remains unchanged
        

//        
        iRobot.direction=Direction.North;
        
        // Test moving in the North direction
        App.move("4"); // Move 4 spaces up
	    System.out.println("Room after moving North:");
	    iRoom.print(); // Print the room to see the updated values
        assertEquals(1, iRoom.room[0][3]); // Check if the robot left a trail in the room
        assertEquals(3, iRobot.x); // Check if the robot's X coordinate remains unchanged
        assertEquals(4, iRobot.y); // Check if the robot's Y coordinate is updated correctly
        
      iRobot.direction=Direction.West;
        
      // Test moving in the West direction
        App.move("2"); // Move 2 spaces to the left
	    System.out.println("Room after moving west:");
	    iRoom.print(); // Print the room to see the updated values
        assertEquals(1, iRoom.room[0][1]); // Check if the robot left a trail in the room
        assertEquals(1, iRobot.x); // Check if the robot's X coordinate is updated correctly
        assertEquals(4, iRobot.y); // Check if the robot's Y coordinate remains unchanged
//        
        iRobot.direction=Direction.South;
//        
        // Test moving in the South direction
        App.move("1"); // Move 1 space down
	    System.out.println("Room after moving south:");
	    iRoom.print(); // Print the room to see the updated values
        assertEquals(1, iRoom.room[1][1]); // Check if the robot left a trail in the room
        assertEquals(1, iRobot.x); // Check if the robot's X coordinate remains unchanged
        assertEquals(3
        		, iRobot.y); // Check if the robot's Y coordinate is updated correctly
	}
	@Test
	void moveToEast() {
		iRobot.setPenDown();
		iRobot.direction=Direction.East;
		iRobot.setXY(0, 0);
        // Test moving in the East direction
	    App.move("3"); // Move 3 spaces to the right
	    System.out.println("Room after moving east:");
	    iRoom.print(); // Print the room to see the updated values
        assertEquals(1, iRoom.room[4][3]); // Check if the robot left a trail in the room
        assertEquals(3, iRobot.x); // Check if the robot's X coordinate is updated correctly
        assertEquals(0, iRobot.y); // Check if the robot's Y coordinate remains unchanged
	}
	@Test
	void moveToWest() {
		iRobot.setPenDown();
		iRobot.direction=Direction.West;
		iRobot.setXY(2, 0);
        // Test moving in the East direction
	    App.move("2"); // Move 2 spaces to the right
	    System.out.println("Room after moving west:");
	    iRoom.print(); // Print the room to see the updated values
        assertEquals(1, iRoom.room[4][0]); // Check if the robot left a trail in the room
        assertEquals(0, iRobot.x); // Check if the robot's X coordinate is updated correctly
        assertEquals(0, iRobot.y); // Check if the robot's Y coordinate remains unchanged
	}
	@Test
	void moveToSouth() {
		iRobot.setPenDown();
		iRobot.direction=Direction.South;
		iRobot.setXY(2, 2);
        // Test moving in the East direction
	    App.move("2"); // Move 3 spaces to the right
	    System.out.println("Room after moving south:");
	    iRoom.print(); // Print the room to see the updated values
        assertEquals(1, iRoom.room[4][2]); // Check if the robot left a trail in the room
        assertEquals(2, iRobot.x); // Check if the robot's X coordinate is updated correctly
        assertEquals(0, iRobot.y); // Check if the robot's Y coordinate remains unchanged
	}
	@Test
	void moveToNorth() {
		iRobot.setPenDown();
		iRobot.direction=Direction.North;
		iRobot.setXY(0, 0);
        // Test moving in the East direction
	    App.move("2"); // Move 3 spaces to the right
	    System.out.println("Room after moving North:");
	    iRoom.print(); // Print the room to see the updated values
        assertEquals(1, iRoom.room[2][0]); // Check if the robot left a trail in the room
        assertEquals(0, iRobot.x); // Check if the robot's X coordinate is updated correctly
        assertEquals(2, iRobot.y); // Check if the robot's Y coordinate remains unchanged
	}
	 ///..condition
	@Test
	void testDirectionEast() {
		iRobot.direction=Direction.East;
		assertEquals(Direction.East,iRobot.direction);
	}
	@Test
	void testDirectionWest() {
		iRobot.direction=Direction.West;
		assertEquals(Direction.West,iRobot.direction);
	}
	@Test
	void testDirectionNorth() {
		iRobot.direction=Direction.North;
		assertEquals(Direction.North,iRobot.direction);
	}
	@Test
	void testDirectionSOuth() {
		iRobot.direction=Direction.South;
		assertEquals(Direction.South,iRobot.direction);
	}
    @Test
    void testinitiateTheRoom(){
    	App.initiateTheRoom("5");
    	///check the room size
    	assertEquals(5, iRoom.room.length);
        assertEquals(5, iRoom.room[0].length);
        //check whether a robot is initiated or not
        assertEquals(0, App.robot.x);
        assertEquals(0, App.robot.y);
    }
    ///..condition
    @Test
    void testconvertInputM() {
    	String inputThatContainsM="m4";
    	String m="m";
    	assertEquals(m,App.convertInput(inputThatContainsM));
    }
    @Test
    void testconvertInputI() {
    	String inputThatContainsI="I5";
    	String i="i";
    	assertEquals(i,App.convertInput(inputThatContainsI));
    }
    ///..condition
    @Test
    void testgetNumberM() {
    	String inputThatContainsM="m4";
    	String i="4";
    	assertEquals(i,App.getNumber(inputThatContainsM));
    }
    @Test
    void testgetNumberI() {
    	String inputThatContainsI="I5";
    	String j="5";
    	assertEquals(j,App.getNumber(inputThatContainsI));
    }
    ///..condition
    @Test
    void penTestRoomTrue() {
    	iRobot.setPenDown();
        assertEquals(true,iRobot.pen);
    }
    @Test
    void penTestRoomFalse() {
    	iRobot.setPenUp();
        assertEquals(false,iRobot.pen);
    }
    @Test
    void testprintThCurrentPositionOfRobot() {
    	iRobot.print();
    }
    @Test
    void testTurnRight() {
    	iRobot.turnRight();
    	assertEquals(Direction.East,iRobot.direction);
    }
    @Test
    void testTurnLeft() {
    	iRobot.turnLeft();
    	assertEquals(Direction.West,iRobot.direction);
    }
}
