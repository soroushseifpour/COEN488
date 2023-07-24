package group.project.coen6761;

import java.util.Scanner;

import group.project.coen6761.Robot.Direction;

public class App 
{
	///...the instance of Room class
	public static Room room;
	//....the instance of Robot
	public static Robot robot;
	public static String getNumber(String c) {
		///....checking for M
		String finalString=c.trim().replaceAll("\\s", "").toLowerCase();
		if(finalString.contains("m")){
			int m=finalString.indexOf("m");
			String index=finalString.substring(m+1,finalString.length());
//			System.out.println(index);
			return index;
		}
		///....checking for I
		else {	
			int m=finalString.indexOf("i");
			String index=finalString.substring(m+1,finalString.length());
//			System.out.println(index);
			return index;
		}
	}

	public static String convertInput(String c) {
		///....checking for M
		String finalString=c.trim().replaceAll("\\s", "").toLowerCase();
		if(finalString.contains("m")){
			return "m";
		}
		///....checking for I
		return "i";
	}
	
	public static void initiateTheRoom(String n) {
		int size=Integer.parseInt(n);
		room=new Room(size);
		robot=new Robot();
//		room.room[room.room.length-1][0]=1;
	}
	public static void printThCurrentPositionOfRobot() {
		robot.print();
	}
	public static void move(String s) {
		int space=Integer.parseInt(s);
		///...EAST
		if(robot.direction==Direction.East) {
		 try {
			int newXPosition=0;
			for(int i=0;i<=space;i++) {
					if(newXPosition>=room.room.length) {
						System.out.println("******Oppps, Cant go further change the direction.******\n");
						break;
					}else {
						newXPosition=(robot.x+i);
						if(robot.pen==true)
						room.room[room.room.length-1-robot.y][newXPosition]=1;					
					}
			}
			robot.setXY(newXPosition, robot.y);
			}catch(ArrayIndexOutOfBoundsException e){
				robot.setXY(room.room.length-1, robot.y);
				System.out.println("******Oppps, Cant go further change the direction.******\n");
			}
		}
		///...WEST
		else if(robot.direction==Direction.West) {
			try {
				int newXPosition=0;
				for(int i=0;i<=space;i++) {
						if(newXPosition<0) {
							System.out.println("******Oppps, Cant go further change the direction.******\n");
							break;
						}else {
							newXPosition=(robot.x-i);
							System.out.println(newXPosition);
							if(robot.pen==true)
							room.room[room.room.length-1-robot.y][newXPosition]=1;					
						}
				}
				robot.setXY(newXPosition, robot.y);
				}catch(ArrayIndexOutOfBoundsException e){
					robot.setXY(0, robot.y);
					System.out.println("******Oppps, Cant go further change the direction.******\n");
				}
		}
		///....NORTH
		else if(robot.direction==Direction.North) {
			try {
				int newYPosition=0;
				for(int j=0;j<=space;j++) {
						if(newYPosition>=room.room.length) {
							System.out.println("******Oppps, Cant go further change the direction.******\n");
							break;
						}else {
							newYPosition=(robot.y+j);
							if(robot.pen==true)
							room.room[room.room.length-1-newYPosition][robot.x]=1;					
						}
				}
				robot.setXY(robot.x, newYPosition);
				}catch(ArrayIndexOutOfBoundsException e){
					robot.setXY(robot.x,room.room.length-1);
					System.out.println("******Oppps, Cant go further change the direction.******\n");
				}
		}
		///....SOUTH
		else {
			try {
				int newYPosition=0;
				for(int j=0;j<=space;j++) {
						if(newYPosition<0) {
							System.out.println("******Oppps, Cant go further change the direction.******\n");
							break;
						}else {
							newYPosition=(robot.y-j);
							if(robot.pen==true)
							room.room[room.room.length-1-newYPosition][robot.x]=1;					
						}
				}
				robot.setXY(robot.x, newYPosition);
				}catch(ArrayIndexOutOfBoundsException e){
					robot.setXY(robot.x,room.room.length-1);
					System.out.println("******Oppps, Cant go further change the direction.******\n");
				}
			}
	}
//	public static void run() {
//	   
//	}
	public static void main( String[] args )
    {
		controler c= new controler();
		c.run();
    }
}
