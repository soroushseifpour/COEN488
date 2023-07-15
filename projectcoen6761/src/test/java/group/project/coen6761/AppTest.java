package group.project.coen6761;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
//import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		if(iRobot.pen==false)
			return;
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
    void testinitiateTheRoom(){
    	App.initiateTheRoom("5");
    	///check the room size
    	assertEquals(5, iRoom.room.length);
        assertEquals(5, iRoom.room[0].length);
        //check whether a robot is initiated or not
        assertEquals(0, App.robot.x);
        assertEquals(0, App.robot.y);
        //check whether the cell is 1 or not
        assertEquals(1, App.room.room[iRoom.room.length-1][0]);
    }
    @Test
    void testconvertInput() {
    	String inputThatContainsM="m4";
    	String m="m";
    	assertEquals(m,App.convertInput(inputThatContainsM));
    	String inputThatContainsI="I5";
    	String i="i";
    	assertEquals(i,App.convertInput(inputThatContainsI));
    }
    @Test
    void testgetNumber() {
    	String inputThatContainsM="m4";
    	String i="4";
    	assertEquals(i,App.getNumber(inputThatContainsM));
    	String inputThatContainsI="I5";
    	String j="5";
    	assertEquals(j,App.getNumber(inputThatContainsI));
    }
}
