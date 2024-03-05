package com.gic.simulator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulatorDemoCheckCollision {

	public static char finalDirection = 'N';
	public static int collPosition = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Please enter number of cars");
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int X = Integer.parseInt(reader.readLine().toString());
//		int Y = 
		Scanner in = new Scanner(System.in);
		 
//        String s = in.nextLine();
//        System.out.println("You entered string " + s);
 
        int noOfCars = in.nextInt();
        System.out.println("You entered integer " + noOfCars);
        
        Car[] carArray = new Car[noOfCars];
        Car car = null;
        System.out.println("Please enter end points");
        int a = in.nextInt();
        System.out.println("You entered integer " + a);
 
        int b = in.nextInt();
        System.out.println("You entered integer " + b);
        
        int[] endpoint = {a,b};
        
        for(int i=0;i<noOfCars;i++) {
        	car = new Car();
        	car.setEndPoint(endpoint);
        	System.out.println("Please enter car name");
        	String carName = in.nextLine();
            
            System.out.println("Car Name " + carName);
            car.setName(carName);
        	System.out.println("Please enter car"+i+" details");
        	System.out.println("Please enter car"+i+" start position");
//        	int c = in.nextInt();
//            System.out.println("You entered integer " + c);
//            car
//            
//            int[] endpoint = {a,b};
            
            System.out.println("Please enter starting position");
            
            int x = in.nextInt();
            System.out.println("You entered integer " + x);
     
            int y = in.nextInt();
            System.out.println("You entered integer " + y);
            
            int[] currentPos = {x,y};
            car.setStartPos(currentPos);
            
            String currentDirection = in.nextLine();
            char direction = currentDirection.charAt(1);
            System.out.println("Your start direction " + direction);
            car.setDirection(direction);
            
            System.out.println("Please enter commands ");
            
            String commands = in.nextLine();
            
            System.out.println("Your commands " + commands);
            car.setCommands(commands);
            carArray[i] = car;
        }
 
        for(Car obj:carArray) {
        	System.out.println("entered value endpoint-->"+obj.getEndPoint()[0] +" "+obj.getEndPoint()[1]+"-->"+obj.getStartPos()[0] +" "+obj.getStartPos()[1]);
        	System.out.println("entered value-->"+obj.getDirection() +"-->"+obj.getCommands());
        	executeCommands(obj);
        }
        boolean collide = false;
        for(int i =0;i<carArray.length;i++) {
        	for(int j=i+1;j<carArray.length;j++) {
        		Car car1 = carArray[i];
        		Car car2 = carArray[j];
        		int[] coll = compareMoves(car1.getMovePos(),car2.getMovePos());
        		if(coll != null) {
        			collide = true;
        			System.out.println("Collision occurs");
        			System.out.println(coll[0] +" "+coll[1]);
        			System.out.println("Collison position--->"+(collPosition+1));
        			break;
        		}
        	}
        	if(collide) {
        		break;
        	}
        }
        
        if(!collide) {
        	System.out.println("no collision");
        }
        
//        int[] result = executeCommands(endpoint,currentPos,direction,commands);
//        System.out.println("result--->"+result + "1-->"+result[0]+"  2--->"+result[1]);
//        System.out.println("final direction--->"+finalDirection);
        
	}
	
	public static boolean checkCollision(Car[] carArray) {
		
		boolean collide = false;
        for(int i =0;i<carArray.length;i++) {
        	for(int j=i+1;j<carArray.length;j++) {
        		Car car1 = carArray[i];
        		Car car2 = carArray[j];
        		int[] coll = compareMoves(car1.getMovePos(),car2.getMovePos());
        		if(coll != null) {
        			collide = true;
        			System.out.println("Collision occurs");
        			System.out.println(coll[0] +" "+coll[1]);
        			System.out.println("Collison position--->"+(collPosition+1));
        			break;
        		}
        	}
        	if(collide) {
        		
        		break;
        	}
        }
        
        if(!collide) {
        	System.out.println("no collision");
        }
        
        return collide;
	}
	
	public static int[] compareMoves(List<int[]> car1Moves,List<int[]> car2Moves) {
		
		int coll[] = null;
		
		for(int i=0;i<car1Moves.size();i++) {
			
			int[] car1 = car1Moves.get(i);
			int[] car2 = car2Moves.get(i);
			if(car1[0] == car2[0] && car1[1] == car2[1]) {
				collPosition = i;
				coll = car1;
				
				break;
			}
		}
		
		return coll;
	}
	
	
	
	public static int[] executeCommands(int[] endPoint,int[] startPos,char currentDirection,String commands) {
		
		
		for(char val:commands.toCharArray()) {
			
			switch(val) {
			case 'R':
				currentDirection = findDirection(currentDirection,'R');
				break;
			
			case 'L':
				currentDirection = findDirection(currentDirection,'L');
				break;
				
			case 'F':
				startPos = newStartPos(endPoint,startPos,currentDirection);
				break;
			
			}
			
		}
		finalDirection = currentDirection;
		return startPos;
	}
	
	public static Car executeCommands(Car car) {
		
		int[] movePos = null;
//		int [][] list = null;
		List<int[]> listMovePos = new ArrayList<>();
		int i = 0 ;
		for(char val:car.getCommands().toCharArray()) {
//			list = new int[][car.getCommands().toCharArray().length];
			switch(val) {
			case 'R':
				car.setDirection(findDirection(car.getDirection(),'R'));
				break;
			
			case 'L':
				car.setDirection(findDirection(car.getDirection(),'L'));
				break;
				
			case 'F':
//				movePos = new int[1];
				movePos = newStartPos(car.getEndPoint(),car.getStartPos(),car.getDirection()).clone();
				break;
			
			}
			if(movePos != null) {
				listMovePos.add(movePos.clone());
			}
			else {
				listMovePos.add(car.getStartPos());
			}
		}
//		finalDirection = currentDirection;
		car.setMovePos(listMovePos);
		return car;
	}
	
	
	public static int[] newStartPos(int[] endpoint,int[] startPos,char currentDirection) {
		
		switch(currentDirection) {
		case 'N':
			if(startPos[1] < endpoint[1]) {
				startPos[1] = startPos[1]+1;
			}
			break;
		
		case 'S':
			if(startPos[1] > 0) {
				startPos[1] = startPos[1]-1;
			}
			break;
			
		case 'E':
			if(startPos[0] < endpoint[0]) {
				startPos[0] = startPos[0]+1;
			}
			break;
		case 'W':
			if(startPos[0] > 0) {
				startPos[0] = startPos[0]-1;
			}
			break;
		
		}
		return startPos;
	}
	
	// we need to check endpoint -1 as max val , we should not increase
	// also 1 is the min val , we should not decrease
	
	public static char findDirection(char current,char newdir) {
		
		if(current == 'N' && newdir == 'L') {
			current = 'W';
		}else if(current == 'N' && newdir == 'R') {
			current = 'E';
		}else if(current == 'S' && newdir == 'R') {//W
			current = 'W';
		}else if(current == 'S' && newdir == 'L') {
			current = 'E';
		}else if(current == 'E' && newdir == 'R') {//S
			current = 'S';
		}else if(current == 'E' && newdir == 'L') {
			current = 'N';
		}else if(current == 'W' && newdir == 'R') {
			current = 'N';
		}else if(current == 'W' && newdir == 'L') {
			current = 'S';
		}
		
		return current;
	}
	
	// so now for multiple cars we need to fetch no of cars first
	// then store in array of input in car object that details
	// then car object we need to iterate 
//	so we need to pass each command to each car start point
	// or we can get all start point for each cars command in a seperate array
	// finally we get 3 arays contain list of start points of 3 cars
	// now we can compare the array values based on index i and if any car start index same return it
	// or return o collison
	

}
