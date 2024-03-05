package com.gic.simulator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SimulatorDemo {
	
	public static char finalDirection = 'N';

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Please enter X and Y endpoint values");
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		int X = Integer.parseInt(reader.readLine().toString());
//		int Y = 
		Scanner in = new Scanner(System.in);
		 
//        String s = in.nextLine();
//        System.out.println("You entered string " + s);
 
        int a = in.nextInt();
        System.out.println("You entered integer " + a);
 
        int b = in.nextInt();
        System.out.println("You entered integer " + b);
        
        int[] endpoint = {a,b};
        
        System.out.println("Please enter starting position");
        
        int x = in.nextInt();
        System.out.println("You entered integer " + x);
 
        int y = in.nextInt();
        System.out.println("You entered integer " + y);
        
        int[] currentPos = {x,y};
        
        String currentDirection = in.nextLine();
        char direction = currentDirection.charAt(1);
        System.out.println("Your start direction " + direction);
        
        System.out.println("Please enter commands ");
        String commands = in.nextLine();
        
        System.out.println("Your commands " + commands);
        
        int[] result = executeCommands(endpoint,currentPos,direction,commands);
        System.out.println("result--->"+result + "1-->"+result[0]+"  2--->"+result[1]);
        System.out.println("final direction--->"+finalDirection);
        
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
