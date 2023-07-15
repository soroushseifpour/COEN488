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
		room.room[room.room.length-1][0]=1;
	}
	public static void printThCurrentPositionOfRobot() {
		robot.print();
	}
	public static void move(String s) {
		int space=Integer.parseInt(s);
		if(robot.pen==false) {
			return;
		}
		else {
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
							room.room[room.room.length-1-robot.y][newXPosition]=1;					
						}
				}
				robot.setXY(newXPosition, robot.y);
				}catch(ArrayIndexOutOfBoundsException e){
					robot.setXY(room.room.length-1, robot.y);
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
	}
	public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        String choice = "";
        boolean isStarted=false;
        while (choice != "Q") {
            System.out.println("********* Welcome to the Console Menu *********");
            System.out.println("1.To initialize the room enter I followed with an intiger:");
            System.out.println("2. To Print the current position of robot enter C:");
            System.out.println("3. To pen up enter U:");
            System.out.println("4. To pen down enter D:");
            System.out.println("5. To Turn right enter R:");
            System.out.println("6. To Turn right enter L:");
            System.out.println("7. To move the robot forward enter M followed by an intiger:");
            System.out.println("8. To print the room enter P:");
            System.out.println("9. To Stop the program Enter Q:");
            System.out.println("************************************************");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            String number="";
            choice=choice.trim().replaceAll("\\s", "").toLowerCase();
            if(choice.contains("m")||choice.trim().replaceAll("\\s", "").toLowerCase().contains("i")) {
            	number=getNumber(choice);
            	choice=convertInput(choice);
            }
            try {
            switch (choice) {
                case "i":
                	initiateTheRoom(number);
                	isStarted=true;
                    break;
                case "c":
                	if(isStarted)
                	printThCurrentPositionOfRobot();
                    break;
                case "u":
                	if(isStarted)
                	robot.setPenUp();
                    break;
                case "d":
                	if(isStarted)
                	robot.setPenDown();
                    break;
                case "r":
                	if(isStarted)
                	robot.turnRight();
                    break;
                case "l":
                	if(isStarted)
                	robot.turnLeft();
                    break;
                case "m":
                	if(isStarted)
                	move(number);
                    break;
                case "p":
                	if(isStarted)
                	room.print();
                    break;
                case "q":
                    System.out.println("Exit the program....");
                    break;    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            }catch(NumberFormatException e) {
            	System.out.println("Invalid input format. Please provide a valid number.");
            }
            System.out.println(); // Add a line break for readability
        }

        scanner.close();
    }
}
