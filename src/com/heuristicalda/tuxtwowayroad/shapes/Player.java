package com.heuristicalda.tuxtwowayroad.shapes;

import com.heuristicalda.tuxtwowayroad.main.TwoWayRoadConstants;
import com.heuristicalda.tuxtwowayroad.shapes.*;

public class Player extends Shape {

	public enum Commands{
		MOVE_LEFT,MOVE_RIGHT,MOVE_UP,MOVE_DOWN
	}
	
	public Player(Position initialPosition,String imageResource,RectangularDimension dimension) {
		super(initialPosition,imageResource);
	}
	
	private void moveLeft()
	{
		this.currentPosition.decX(TwoWayRoadConstants.PLAYER_HORIZONTAL_MOVE_DEFAULT);
	}

	private void moveRight()
	{
		this.currentPosition.incX(TwoWayRoadConstants.PLAYER_HORIZONTAL_MOVE_DEFAULT);
	}

	private void moveUp()
	{
		this.currentPosition.decY(TwoWayRoadConstants.PLAYER_VERTICAL_MOVE_DEFAULT);
	}

	private void moveDown()
	{
		this.currentPosition.incY(TwoWayRoadConstants.PLAYER_VERTICAL_MOVE_DEFAULT);
	}
	
	public void executeCommand(Player.Commands command)
	{
		if (command == Commands.MOVE_UP)
		{
			moveUp();
		}
		else if ( command == Commands.MOVE_DOWN)
		{
			moveDown();
		}
		else if (command == Commands.MOVE_LEFT)
		{
			moveLeft();
		}
		else if (command == Commands.MOVE_RIGHT)
		{
			moveRight();
		}
	}

}
