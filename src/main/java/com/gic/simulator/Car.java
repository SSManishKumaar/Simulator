package com.gic.simulator;

import java.util.List;

public class Car {

	char direction = 'N';
	
	int[] endPoint;
	
	int[] startPos;
	
	String commands;
	
	List<int[]> movePos;
	
	String name;
	

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public int[] getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int[] endPoint) {
		this.endPoint = endPoint;
	}

	public int[] getStartPos() {
		return startPos;
	}

	public void setStartPos(int[] startPos) {
		this.startPos = startPos;
	}

	public String getCommands() {
		return commands;
	}

	public void setCommands(String commands) {
		this.commands = commands;
	}

	public List<int[]> getMovePos() {
		return movePos;
	}

	public void setMovePos(List<int[]> movePos) {
		this.movePos = movePos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
